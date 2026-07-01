# 📘 Complete Software Documentation — Desktop Billing Software

> **Purpose of this document:** You are learning Java and want to rebuild this exact software from scratch.
> This document tells you **everything** the current software does, **every technology** it uses,
> **what Java technologies** replace each one, and a **step-by-step learning path** to build it while learning.

---

## Table of Contents

1. [What This Software Is](#1-what-this-software-is)
2. [Current Tech Stack (Complete Breakdown)](#2-current-tech-stack-complete-breakdown)
3. [Application Architecture](#3-application-architecture)
4. [Every Feature — Detailed](#4-every-feature--detailed)
5. [Database Schema — All 13 Tables](#5-database-schema--all-13-tables)
6. [Business Logic — GST, Stock, Numbering](#6-business-logic--gst-stock-numbering)
7. [All 50+ API Operations](#7-all-50-api-operations)
8. [UI Pages and Navigation](#8-ui-pages-and-navigation)
9. [Java Technologies You Need to Learn](#9-java-technologies-you-need-to-learn)
10. [Step-by-Step Learning Path (Build While Learning)](#10-step-by-step-learning-path-build-while-learning)
11. [Java Project Structure](#11-java-project-structure)
12. [File-by-File Mapping (Current → Java)](#12-file-by-file-mapping-current--java)

---

## 1. What This Software Is

This is a **cross-platform desktop billing and invoice management application** built for **Indian businesses**. It runs on Windows, macOS, and Linux as a standalone desktop app.

**Key facts:**
- It works **offline** — all data is stored locally on the user's computer
- It handles **Indian GST tax** calculations (CGST, SGST, IGST)
- It generates **PDF invoices** and **Excel exports**
- It manages **customers, products, suppliers, invoices, quotations, and purchases**
- It tracks **inventory/stock** levels automatically
- It has an **admin panel** with password protection and recovery codes
- It supports **auto-updates** from GitHub Releases
- It can be packaged into `.exe` (Windows), `.dmg` (Mac), `.AppImage` (Linux) installers

---

## 2. Current Tech Stack (Complete Breakdown)

### 2.1 Runtime & Framework

| Technology | Version | What It Does | Why It's Used |
|-----------|---------|-------------|---------------|
| **Electron** | 33.3.1 | Desktop runtime — wraps a Chromium browser + Node.js into a native desktop app | Lets you build desktop apps using web technologies (HTML, CSS, JS) |
| **Node.js** | (bundled with Electron) | Server-side JavaScript runtime | Powers the "backend" part of the app (database, file I/O) |

**What this means:** The app is essentially a **website running inside a browser window** that's been packaged as a desktop app. Electron gives it access to the filesystem, database, and native OS features.

### 2.2 Frontend (User Interface)

| Technology | Version | What It Does | Why It's Used |
|-----------|---------|-------------|---------------|
| **React** | 18.3.1 | UI framework — builds the interface using reusable components | Most popular UI library; component-based architecture |
| **TypeScript** | 5.7.2 | Adds type safety to JavaScript | Catches bugs before runtime; better code quality |
| **React Router** | 6.28.0 | Handles page navigation (URL routing) | Lets you navigate between pages like Dashboard, Invoices, etc. |
| **Zustand** | 5.0.2 | Lightweight state management library | Manages shared data between components |
| **Tailwind CSS** | 3.4.16 | Utility-first CSS framework for styling | Fast styling with pre-built classes like `bg-blue-500`, `p-4` |
| **Lucide React** | 0.468.0 | Icon library | Provides 1000+ SVG icons (FileText, Users, Package, etc.) |

### 2.3 Backend (Data & Logic)

| Technology | Version | What It Does | Why It's Used |
|-----------|---------|-------------|---------------|
| **better-sqlite3** | 11.7.0 | SQLite database driver | Stores all data locally in a single `.db` file |
| **ExcelJS** | 4.4.0 | Generates `.xlsx` Excel files | Exports invoices/purchases to Excel |
| **date-fns** | 4.1.0 | Date utility library | Formats dates in Indian format (DD-MMM-YYYY) |

### 2.4 Build & Packaging

| Technology | Version | What It Does | Why It's Used |
|-----------|---------|-------------|---------------|
| **electron-vite** | 2.3.0 | Build tool (based on Vite) | Bundles all code for production; provides hot-reload in development |
| **Vite** | 5.4.11 | Fast JavaScript bundler | Powers electron-vite under the hood |
| **electron-builder** | 25.1.8 | Packages the app into installers | Creates `.exe`, `.dmg`, `.AppImage` files |
| **PostCSS** | 8.4.49 | CSS post-processor | Works with Tailwind CSS to process utility classes |
| **Autoprefixer** | 10.4.20 | Adds browser CSS prefixes automatically | Ensures CSS works across all browsers |

### 2.5 Distribution & Updates

| Technology | Version | What It Does | Why It's Used |
|-----------|---------|-------------|---------------|
| **electron-updater** | 6.7.3 | Auto-update mechanism | Downloads and installs updates from GitHub Releases |
| **GitHub Actions** | - | CI/CD pipeline | Automatically builds the app for all platforms when code is pushed |

### 2.6 Development Tools

| Technology | Version | What It Does |
|-----------|---------|-------------|
| **ESLint** | 9.16.0 | Lints code for errors and style issues |
| **@vitejs/plugin-react** | 4.3.4 | Enables React support in Vite |
| **@electron-toolkit/utils** | 3.0.0 | Helper utilities for Electron development |
| **@electron-toolkit/preload** | 3.0.1 | Preload script utilities for IPC communication |

---

## 3. Application Architecture

### 3.1 Electron's 3-Process Model

The app runs in **3 separate processes** that communicate via IPC (Inter-Process Communication):

```
┌──────────────────────────────────────────────────────────────────┐
│                    MAIN PROCESS (Node.js)                        │
│                                                                  │
│  ┌─────────┐  ┌───────────┐  ┌──────────┐  ┌────────────────┐  │
│  │Database │  │IPC Handler│  │  Stock    │  │  Auto Updater  │  │
│  │(SQLite) │  │(12 modules│  │  Service  │  │  (GitHub)      │  │
│  └─────────┘  └───────────┘  └──────────┘  └────────────────┘  │
│                       ▲                                          │
│                       │ IPC (invoke/handle)                      │
│                       ▼                                          │
│  ┌─────────────────────────────────────────────────────────┐    │
│  │              PRELOAD SCRIPT (Bridge)                     │    │
│  │  Exposes 50+ API functions to the renderer safely        │    │
│  └─────────────────────────────────────────────────────────┘    │
│                       ▲                                          │
│                       │ window.api.*                              │
│                       ▼                                          │
│  ┌─────────────────────────────────────────────────────────┐    │
│  │              RENDERER PROCESS (Chromium)                  │    │
│  │                                                           │    │
│  │  React App → Pages → Components → UI                     │    │
│  │  (Dashboard, Invoices, Products, Settings, etc.)          │    │
│  └─────────────────────────────────────────────────────────┘    │
└──────────────────────────────────────────────────────────────────┘
```

### 3.2 How Data Flows (Example: Creating an Invoice)

```
User clicks "Save Invoice" in the UI
    ↓
React component calls: window.api.createInvoice(data)
    ↓
Preload script routes to: ipcRenderer.invoke('invoices:create', data)
    ↓
Main process handler receives the call
    ↓
Handler generates invoice number (INV-0001)
    ↓
Handler INSERTs into 'invoices' table
    ↓
Handler INSERTs each line item into 'invoice_items' table
    ↓
Handler updates the counter in 'counters' table
    ↓
Stock service DEDUCTS stock for each product sold
    ↓
Stock service logs movements in 'stock_history' table
    ↓
Handler returns { id, invoice_number } back to UI
    ↓
React navigates to the invoice view page
```

---

## 4. Every Feature — Detailed

### 4.1 Dashboard
- **Total Revenue** card — sum of all non-cancelled invoices
- **Total Invoices** card — count of all invoices, with cancelled count
- **This Month's Revenue** and **This Month's Invoices** — filtered by current month
- **Unpaid Invoices** — count and total pending amount
- **Customer Count** and **Product Count** cards
- **Low Stock Alerts** — products where `current_stock < min_stock_level` (shows top 6)
- **Quotation Overview** — shows total, draft, sent, accepted counts
- **Quick Actions** — buttons to create Invoice, Quotation, Purchase, add Customer, add Product

### 4.2 Invoice Management (Sales Side)
- **Invoice List** — shows all invoices sorted by date (newest first)
  - Columns: Invoice #, Customer Name, Date, Amount, Status, Payment Status
  - Search/filter functionality
- **Create Invoice**:
  - Select customer (from dropdown)
  - Set invoice date and due date
  - Select place of supply (determines IGST vs CGST+SGST)
  - Add line items: select product, enter quantity, unit price, discount
  - Auto-calculates: taxable amount, tax breakdown, subtotal
  - Add transportation charges
  - Auto round-off to nearest rupee
  - Add notes and terms & conditions
  - Auto-generates invoice number (e.g., INV-0001, INV-0002...)
- **View Invoice** — read-only detailed view
- **Edit Invoice** — modify existing invoice (reverses old stock, applies new stock)
- **Delete Invoice** — removes invoice and reverses stock movements
- **Cancel Invoice** — marks as cancelled, reverses stock (keeps record)
- **Generate PDF** — creates A4 PDF with:
  - Company logo and details
  - Customer billing details (name, address, GSTIN)
  - Itemized table with HSN codes, quantities, rates, tax
  - Tax summary (CGST/SGST or IGST)
  - Transportation charges and round-off
  - Amount in words (Indian numbering: Crore, Lakh, Thousand)
  - Authorized signatory section
  - Watermark "CANCELLED" if cancelled
- **Export to Excel** — exports all invoices with key columns

### 4.3 Quotation Management
- **Quotation List** — all quotations (soft-deleted ones hidden)
- **Create Quotation** — same form as invoice but with quotation fields
  - Has validity date instead of due date
  - Statuses: Draft → Sent → Accepted/Rejected/Expired
- **Edit / View / Delete Quotation**
- **Convert to Invoice** — one-click conversion:
  - Copies all data (customer, items, amounts) to a new invoice
  - Marks quotation as "accepted"
  - Auto-generates new invoice number
- **Generate Quotation PDF** — green-themed PDF layout (vs blue for invoices)

### 4.4 Purchase Management (Supplier Side)
- **Purchase List** — all purchases from suppliers
- **Create Purchase**:
  - Select supplier
  - Set purchase date, due date
  - Enter supplier's invoice number
  - Add line items (same as invoice)
  - Stock is ADDED when purchase is created
- **Edit / View / Delete Purchase**
  - Edit reverses old stock, applies new stock
  - Delete reverses stock movements

### 4.5 Customer Management
- **Customer List** — all customers sorted by creation date
- **Create Customer**:
  - Auto-generates customer code (CUST-0001)
  - Fields: Name, Email, Phone, Address, City, State (Indian states dropdown), Pincode
  - GSTIN (validated format: e.g., 27AABCU9603R1ZM)
  - State code (auto-filled from state selection)
  - ID Type: GSTIN / PAN / Aadhaar / None
- **Edit / Delete Customer**
- Database transactions used for consistency

### 4.6 Product Management (Inventory)
- **Product List** — only active products (soft-deleted ones hidden)
- **Create Product**:
  - Auto-generates product code (PROD-0001)
  - Fields: Name, Description, HSN Code, SAC Code
  - Unit type (from 21 options: Nos, Pcs, Kg, Gm, Ltr, Mtr, Box, Pack, Set, etc.)
  - Price, Tax Rate (0%, 5%, 12%, 18%, 28%)
  - Opening Stock, Minimum Stock Level
- **Edit / Delete Product** (soft delete — sets `is_active = 0`)
- **Stock History** — full audit trail per product:
  - Opening stock entries
  - Sale deductions (linked to specific invoices)
  - Purchase additions (linked to specific purchases)
  - Manual adjustments with notes
  - Stock reversals (when invoices/purchases are edited/deleted/cancelled)
- **Low Stock Alert** — products below minimum stock level
- **Manual Stock Adjustment** — admin can adjust stock with notes

### 4.7 Supplier Management
- **Supplier List** — all active suppliers
- **Create Supplier**: Name, GSTIN, Address, City, State, State Code, Phone, Email
- **Edit / Delete Supplier** (soft delete — sets `is_deleted = 1`)

### 4.8 Settings
- **Company Logo**: Upload, preview, drag-and-drop, delete (stored as file in app data dir)
  - Supports: PNG, JPG, GIF, SVG, WebP (max 5MB)
- **Company Details**: Name, GSTIN, Phone, Email, Address, City, State, Pincode
  - State dropdown with all 37 Indian states/UTs with codes
- **Document Numbering**: Customize prefixes for Invoice, Quotation, Purchase
- **Default Terms & Conditions**: Text area for default T&C on documents

### 4.9 Admin Panel
- **Password-Protected**: Must enter password to access (default: admin123)
- **First-Time Setup**: Shows recovery code on first access (must save it)
- **Login Screen**: Password input with "Forgot Password?" option
- **Forgot Password**: Reset using 8-character recovery code
- **Admin Dashboard** (after login):
  - **Change Password**: Current → New → Confirm
  - **View Recovery Code**: Requires current password to view
  - **Database Statistics**: Customer/Product/Invoice/Quotation counts
  - **System Information**: App version, database type, framework info

### 4.10 Notifications System
- **Low Stock Alerts** — products below minimum stock (top 5)
- **Unpaid Invoice Alerts** — invoices with "unpaid" status (top 5)
- **Pending Quotation Alerts** — quotations in "sent" status (top 3)
- **Notification Count** — badge on header showing total alerts

### 4.11 Auto-Updater
- Checks GitHub Releases for new versions 5 seconds after app launch
- Shows update notification in the UI
- User can download update with progress bar
- Quit and install button
- Only works in production (skipped in development)

### 4.12 PDF Generation
- **Invoice PDF**: Blue-themed, A4 layout
- **Quotation PDF**: Green-themed, A4 layout
- Features of both:
  - Company header with logo, name, GSTIN, address
  - Customer/client billing details
  - Itemized table: #, Description, HSN, Qty, Rate, Tax%, Amount
  - Tax summary (CGST+SGST or IGST based on state matching)
  - Transportation charges, Round-off
  - Grand total with **amount in words** (Indian numbering)
  - Notes and Terms & Conditions
  - Authorized Signatory section
- Generated via hidden Electron BrowserWindow → printToPDF
- Auto-opens the PDF after saving

### 4.13 Excel Export
- **Invoice Export**: Invoice #, Date, Customer, GSTIN, Total, Status, Payment
- **Purchase Export**: Purchase #, Date, Supplier, GSTIN, Total, Due Date, Payment
- User picks save location via native file dialog
- Styled header row (bold)

---

## 5. Database Schema — All 13 Tables

### 5.1 `customers`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key, auto-increment |
| customer_code | TEXT | Unique, e.g., "CUST-0001" |
| name | TEXT | Required |
| email | TEXT | Optional |
| phone | TEXT | Optional |
| address | TEXT | Optional |
| city | TEXT | Optional |
| state | TEXT | Optional |
| pincode | TEXT | Optional |
| gstin | TEXT | Optional, validated format |
| id_type | TEXT | Default 'none' (gstin/pan/aadhaar/none) |
| state_code | TEXT | e.g., "27" for Maharashtra |
| created_at | DATETIME | Auto-set |
| updated_at | DATETIME | Auto-set |

### 5.2 `products`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| product_code | TEXT | Unique, e.g., "PROD-0001" |
| name | TEXT | Required |
| description | TEXT | Optional |
| hsn_code | TEXT | Harmonized System of Nomenclature code |
| sac_code | TEXT | Service Accounting Code |
| unit | TEXT | Default 'Nos' (from 21 unit types) |
| price | REAL | Required |
| tax_rate | REAL | Default 18.00 (0/5/12/18/28) |
| opening_stock | REAL | Default 0 |
| current_stock | REAL | Default 0, auto-updated |
| min_stock_level | REAL | Default 10, triggers low stock alert |
| is_active | INTEGER | Default 1 (soft delete flag) |
| created_at | DATETIME | Auto-set |
| updated_at | DATETIME | Auto-set |

### 5.3 `suppliers`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| name | TEXT | Required |
| gstin | TEXT | Optional |
| address, city, state, state_code | TEXT | Address fields |
| phone, email | TEXT | Contact info |
| is_deleted | INTEGER | Default 0 (soft delete) |
| created_at, updated_at | DATETIME | Timestamps |

### 5.4 `invoices`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| invoice_number | TEXT | Unique, e.g., "INV-0001" |
| customer_id | INTEGER | FK → customers(id) |
| invoice_date | TEXT | Required |
| due_date | TEXT | Optional |
| place_of_supply | TEXT | Determines IGST vs CGST+SGST |
| subtotal | REAL | Sum of all item taxable amounts |
| cgst_amount | REAL | Central GST |
| sgst_amount | REAL | State GST |
| igst_amount | REAL | Integrated GST (interstate) |
| total_tax | REAL | Sum of all taxes |
| total_amount | REAL | Grand total after round-off |
| round_off | REAL | Rounding adjustment |
| transportation_charges | REAL | Additional charges |
| status | TEXT | Default 'draft' (draft/sent/paid) |
| payment_status | TEXT | Default 'unpaid' (unpaid/partial/paid) |
| is_cancelled | INTEGER | Default 0 |
| is_edited | INTEGER | Default 0, set to 1 on edit |
| cancelled_at | DATETIME | When cancelled |
| notes | TEXT | Optional |
| terms_conditions | TEXT | Optional |
| created_by | TEXT | Optional |
| created_at, updated_at | DATETIME | Timestamps |

### 5.5 `invoice_items`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| invoice_id | INTEGER | FK → invoices(id) ON DELETE CASCADE |
| product_id | INTEGER | FK → products(id) |
| description | TEXT | Item description |
| hsn_code | TEXT | HSN code for the item |
| quantity | REAL | Quantity sold |
| unit | TEXT | Unit type |
| unit_price | REAL | Price per unit |
| discount_percent | REAL | Discount % |
| discount_amount | REAL | Calculated discount |
| taxable_amount | REAL | After discount |
| tax_rate | REAL | GST rate |
| cgst_rate, cgst_amount | REAL | CGST breakdown |
| sgst_rate, sgst_amount | REAL | SGST breakdown |
| igst_rate, igst_amount | REAL | IGST breakdown |
| total_amount | REAL | Line total |
| created_at | DATETIME | Timestamp |

### 5.6 `quotations` — Same structure as invoices but with:
- `quotation_number` instead of `invoice_number`
- `quotation_date` instead of `invoice_date`
- `valid_until` instead of `due_date`
- `is_deleted` instead of `is_cancelled` (soft delete)
- Statuses: draft / sent / accepted / rejected / expired

### 5.7 `quotation_items` — Same structure as `invoice_items` with `quotation_id`

### 5.8 `purchases` — Similar to invoices but for supplier side:
- `purchase_number`, `supplier_id` (FK → suppliers)
- `supplier_invoice_number` — the supplier's own invoice number
- No `status` field; uses `payment_status` and `is_deleted`

### 5.9 `purchase_items` — Same structure as invoice_items with `purchase_id`

### 5.10 `counters`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| counter_type | TEXT | Unique: 'invoice', 'quotation', 'purchase', 'customer', 'product' |
| current_value | INTEGER | Last used number |
| prefix | TEXT | e.g., 'INV-', 'QUO-', 'PUR-' |
| updated_at | DATETIME | Timestamp |

### 5.11 `settings`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| key | TEXT | Unique setting key (e.g., 'company_name', 'admin_password') |
| value | TEXT | Setting value |
| updated_at | DATETIME | Timestamp |

**Settings keys used:**
- `company_name`, `company_gstin`, `company_address`, `company_city`, `company_state`, `company_state_code`, `company_pincode`, `company_phone`, `company_email`
- `invoice_prefix`, `quotation_prefix`, `purchase_prefix`
- `terms_conditions`
- `admin_password` (default: "admin123")
- `recovery_code` (8-character alphanumeric)
- `recovery_code_shown` (boolean flag)
- `company_logo` (file path to stored logo image)

### 5.12 `gst_reports`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| month, year | INTEGER | Report period |
| total_invoices | INTEGER | Count |
| total_sales | REAL | Total sales amount |
| total_cgst, total_sgst, total_igst | REAL | Tax breakdowns |
| report_generated_at | DATETIME | When generated |

### 5.13 `stock_history`
| Column | Type | Notes |
|--------|------|-------|
| id | INTEGER | Primary key |
| product_id | INTEGER | FK → products(id) |
| movement_type | TEXT | opening / sale / purchase / adjustment / sale_reversal / purchase_reversal |
| quantity | REAL | Positive = addition, Negative = deduction |
| reference_type | TEXT | invoice / purchase / manual |
| reference_id | INTEGER | ID of the invoice/purchase |
| notes | TEXT | Description of the movement |
| previous_stock | REAL | Stock before movement |
| new_stock | REAL | Stock after movement |
| created_at | DATETIME | Timestamp |

---

## 6. Business Logic — GST, Stock, Numbering

### 6.1 GST Tax Calculation (India-Specific)

**Rule:** India has a dual-GST system:
- **Intrastate** (same state): Tax is split into CGST (Central) + SGST (State) — each is half the rate
- **Interstate** (different states): Full tax is charged as IGST (Integrated)

**Available tax rates:** 0%, 5%, 12%, 18%, 28%

**Example — 18% GST on ₹1000 item:**
- Intrastate: CGST = 9% (₹90) + SGST = 9% (₹90) = ₹180 total tax
- Interstate: IGST = 18% (₹180) = ₹180 total tax

**How the app determines this:**
1. Company state comes from Settings (e.g., "Maharashtra")
2. Customer state comes from the Customer record
3. If `company_state !== customer_state` → Interstate → Use IGST
4. If same state → Intrastate → Use CGST + SGST

**GSTIN validation regex:** `^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$`

### 6.2 Automatic Document Numbering

Each document type has a counter in the `counters` table:
1. Read current value and prefix
2. Increment: `new_number = current_value + 1`
3. Format: `{prefix}{number padded to 4 digits}` → e.g., `INV-0042`
4. Save the incremented counter back

### 6.3 Stock Management

**On Invoice Create:** For each item with a `product_id`:
- Deduct stock: `current_stock = current_stock - quantity`
- Log in `stock_history` with type = 'sale', reference_type = 'invoice'

**On Purchase Create:** For each item with a `product_id`:
- Add stock: `current_stock = current_stock + quantity`
- Log in `stock_history` with type = 'purchase', reference_type = 'purchase'

**On Invoice/Purchase Edit:**
1. First, reverse ALL previous stock movements for that document
2. Delete old line items
3. Insert new line items
4. Apply new stock movements

**On Invoice Cancel/Delete or Purchase Delete:**
- Reverse all stock movements for that document

**Manual Stock Adjustment:** Admin can add/remove stock with notes

### 6.4 Amount in Words (Indian Numbering)

Converts ₹12,34,567.89 to: "Rupees Twelve Lakh Thirty Four Thousand Five Hundred Sixty Seven and Eighty Nine Paise Only"

Uses Indian place values: Crore → Lakh → Thousand → Hundred

### 6.5 Round-Off Logic

```
totalBeforeRound = subtotal + totalTax + transportationCharges
grandTotal = Math.round(totalBeforeRound)   // round to nearest rupee
roundOff = grandTotal - totalBeforeRound      // can be +/- small amount
```

---

## 7. All 50+ API Operations

The app exposes these operations through the preload bridge (`window.api.*`):

### Customer Operations (5)
| API | Operation |
|-----|-----------|
| `getCustomers()` | Get all customers, sorted newest first |
| `getCustomer(id)` | Get single customer by ID |
| `createCustomer(data)` | Create with auto-generated code, uses DB transaction |
| `updateCustomer(id, data)` | Update customer fields |
| `deleteCustomer(id)` | Hard delete customer |

### Product Operations (8)
| API | Operation |
|-----|-----------|
| `getProducts()` | Get all active products |
| `getProduct(id)` | Get single product |
| `createProduct(data)` | Create with auto code + optional opening stock |
| `updateProduct(id, data)` | Update product (not stock) |
| `deleteProduct(id)` | Soft delete (set is_active = 0) |
| `getStockHistory(productId)` | Get full stock audit trail |
| `getLowStockProducts()` | Get products below min level |
| `adjustStock(productId, qty, notes)` | Manual stock adjustment |

### Supplier Operations (5)
| API | Operation |
|-----|-----------|
| `getSuppliers()` | Get all non-deleted suppliers |
| `getSupplier(id)` | Get single supplier |
| `createSupplier(data)` | Create supplier |
| `updateSupplier(id, data)` | Update supplier |
| `deleteSupplier(id)` | Soft delete |

### Invoice Operations (7)
| API | Operation |
|-----|-----------|
| `getInvoices()` | Get all with customer names (JOIN) |
| `getInvoice(id)` | Get invoice + all line items + customer details |
| `getNextInvoiceNumber()` | Preview next invoice number |
| `createInvoice(data)` | Create + items + update counter + deduct stock |
| `updateInvoice(id, data)` | Reverse stock → delete items → update → new items → new stock |
| `deleteInvoice(id)` | Reverse stock → delete items → delete invoice |
| `cancelInvoice(id)` | Reverse stock → mark as cancelled |

### Quotation Operations (6)
| API | Operation |
|-----|-----------|
| `getQuotations()` | Get all non-deleted with customer names |
| `getQuotation(id)` | Get quotation + items + customer details |
| `createQuotation(data)` | Create + items + update counter |
| `updateQuotation(id, data)` | Delete items → update → new items |
| `deleteQuotation(id)` | Soft delete |
| `convertToInvoice(id)` | Copy to new invoice → mark quotation as accepted |

### Purchase Operations (5)
| API | Operation |
|-----|-----------|
| `getPurchases()` | Get all non-deleted with supplier names |
| `getPurchase(id)` | Get purchase + items + supplier details |
| `createPurchase(data)` | Create + items + update counter + add stock |
| `updatePurchase(id, data)` | Reverse stock → update → new stock |
| `deletePurchase(id)` | Reverse stock → soft delete |

### Analytics (1)
| API | Operation |
|-----|-----------|
| `getDashboardStats()` | Returns: total revenue, invoice counts, unpaid stats, monthly stats, quotation breakdown, customer/product counts, 6-month trend |

### Settings (3)
| API | Operation |
|-----|-----------|
| `getSettings()` | Get all settings (excludes password, recovery code, logo) |
| `updateSettings(data)` | Upsert multiple settings at once |

### Logo (3)
| API | Operation |
|-----|-----------|
| `uploadLogo(base64, fileName)` | Save logo file to app data, store path in settings |
| `getLogo()` | Read logo file, return as base64 string |
| `deleteLogo()` | Delete logo file and settings entry |

### Admin/Auth (7)
| API | Operation |
|-----|-----------|
| `verifyPassword(password)` | Check if password matches stored hash |
| `changePassword(current, new)` | Change password (validates current first) |
| `getRecoveryCode(password)` | View recovery code (requires password) |
| `resetWithRecoveryCode(code, newPw)` | Reset password + generate new recovery code |
| `isFirstTimeSetup()` | Check if recovery code has been shown |
| `markRecoveryCodeShown()` | Mark recovery code as shown |
| `getInitialRecoveryCode()` | Get recovery code for first-time display |

### PDF (2)
| API | Operation |
|-----|-----------|
| `generateInvoicePdf(id)` | Generate + save + open invoice PDF |
| `generateQuotationPdf(id)` | Generate + save + open quotation PDF |

### Excel (1)
| API | Operation |
|-----|-----------|
| `exportToExcel(type)` | Export invoices or purchases to .xlsx |

### Notifications (2)
| API | Operation |
|-----|-----------|
| `getNotifications()` | Get low stock + unpaid + pending quotation alerts |
| `getNotificationCount()` | Get total alert count (for badge) |

### Auto-Update (4)
| API | Operation |
|-----|-----------|
| `checkForUpdate()` | Check GitHub for new version |
| `downloadUpdate()` | Download the update |
| `installUpdate()` | Quit and install |
| `getAppVersion()` | Get current app version |

---

## 8. UI Pages and Navigation

### 8.1 Sidebar Navigation (Always Visible)

```
┌──────────────────────┐
│  🧾 Billing Pro       │
│  Invoice Management   │
├──────────────────────┤
│  📊 Dashboard         │
│  📄 Invoices          │
│  ✅ Quotations        │
│  🛒 Purchases         │
│  👥 Customers         │
│  📦 Products          │
│  🚛 Suppliers         │
│  ⚙️ Settings          │
├──────────────────────┤
│  📈 Quick Stats       │
│  Invoice system ready │
└──────────────────────┘
```

### 8.2 Header Bar
- Page title
- Notification bell icon with count badge
- Notification dropdown panel
- Admin panel link (lock icon)

### 8.3 All Routes (20 pages)

| Route | Page | Description |
|-------|------|-------------|
| `/` | Dashboard | Main analytics page |
| `/invoices` | InvoiceList | All invoices table |
| `/invoices/create` | CreateInvoice | Invoice creation form |
| `/invoices/:id` | ViewInvoice | Read-only invoice view |
| `/invoices/:id/edit` | EditInvoice | Invoice edit form |
| `/quotations` | QuotationList | All quotations table |
| `/quotations/create` | CreateQuotation | Quotation creation form |
| `/quotations/:id` | ViewQuotation | Read-only quotation view |
| `/quotations/:id/edit` | EditQuotation | Quotation edit form |
| `/purchases` | PurchaseList | All purchases table |
| `/purchases/create` | CreatePurchase | Purchase creation form |
| `/purchases/:id` | ViewPurchase | Read-only purchase view |
| `/purchases/:id/edit` | EditPurchase | Purchase edit form |
| `/customers` | CustomerList | Customer management |
| `/products` | ProductList | Product & inventory management |
| `/suppliers` | SupplierList | Supplier management |
| `/settings` | Settings | Company & app configuration |
| `/admin` | Admin | Password-protected admin panel |

---

## 9. Java Technologies You Need to Learn

Here is **every technology** you need, mapped from the current stack, with what it does and where to learn it:

### 9.1 Core Java (You're Learning This)

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **Java Basics** — variables, data types, loops, conditionals | Foundation for everything | JavaScript/TypeScript basics |
| **OOP** — classes, objects, inheritance, interfaces, encapsulation | Structure your entire app | TypeScript classes/interfaces |
| **Collections** — ArrayList, HashMap, etc. | Store and manipulate lists of data | JavaScript arrays and objects |
| **Exception Handling** — try/catch, custom exceptions | Handle errors gracefully | try/catch in TypeScript |
| **File I/O** — read/write files | Save/load logos, PDFs | Node.js `fs` module |
| **`java.time` API** — LocalDate, LocalDateTime, DateTimeFormatter | Date handling | `date-fns` library |

### 9.2 JavaFX (User Interface) — Replaces Electron + React + Tailwind

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **JavaFX Basics** — Stage, Scene, Nodes | Create windows and UI structure | Electron's BrowserWindow |
| **FXML** — XML-based UI layout files | Define UI layouts declaratively | JSX in React components |
| **Scene Builder** — visual drag-and-drop tool | Design your UI visually | Like a code-free React designer |
| **Controllers** — Java classes that handle FXML events | Handle button clicks, form inputs | React event handlers |
| **JavaFX CSS** — styling nodes with CSS | Style your interface | Tailwind CSS classes |
| **TableView** — data tables | Display lists of invoices, customers | HTML `<table>` elements |
| **Layouts** — VBox, HBox, GridPane, BorderPane, AnchorPane | Arrange UI elements | CSS flexbox/grid |
| **Navigation** — switching between Scenes/FXML files | Move between pages | React Router |
| **Dialogs and Alerts** — confirmation, input, error popups | User confirmations/errors | JavaScript `alert()`/`confirm()` |
| **Charts** — BarChart, PieChart, LineChart | Dashboard analytics | Currently text-only stats |
| **AtlantaFX** — modern theme library | Make UI look professional | Tailwind CSS styling |

**Free tool:** Download [Scene Builder](https://gluonhq.com/products/scene-builder/) — it lets you design JavaFX UIs by dragging and dropping, and generates FXML files for you.

### 9.3 JDBC + SQLite (Database) — Replaces better-sqlite3

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **JDBC Basics** — Connection, Statement, ResultSet | Connect Java to databases | `better-sqlite3` API |
| **PreparedStatement** — parameterized queries | Prevent SQL injection, insert data | `db.prepare()` |
| **Transaction Management** — commit, rollback | Atomic operations (e.g., create invoice + items) | `db.transaction()` |
| **DAO Pattern** — Data Access Object classes | Organize all database operations | IPC handler files |
| **sqlite-jdbc driver** — `org.xerial:sqlite-jdbc` | SQLite driver for Java | `better-sqlite3` npm package |

**Key point:** Your SQL queries stay EXACTLY the same. `CREATE TABLE`, `INSERT INTO`, `SELECT`, `UPDATE`, `DELETE` — all identical. Only the Java wrapper code changes.

### 9.4 Apache POI (Excel Export) — Replaces ExcelJS

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **Apache POI XSSF** — create .xlsx workbooks | Export data to Excel | `ExcelJS` |
| **Workbook, Sheet, Row, Cell** — POI data model | Write data to Excel cells | ExcelJS Workbook/Worksheet |
| **Cell Styles** — fonts, colors, borders | Format Excel headers | `worksheet.getRow(1).font = { bold: true }` |

### 9.5 iText or JasperReports (PDF Generation) — Replaces Electron's printToPDF

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **iText 7** — programmatic PDF creation | Generate invoice/quotation PDFs | HTML → printToPDF |
| **Paragraph, Table, Cell** — iText elements | Build PDF layout with text and tables | HTML elements in PDF template |
| **Fonts & Styling** — colors, borders, sizing | Make PDFs look professional | CSS in HTML template |
| **Images in PDF** — embed company logo | Add logo to invoices | `<img>` tag in HTML template |

**Alternative:** JasperReports — more powerful but steeper learning curve. Start with iText.

### 9.6 Build & Packaging

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **Maven** — dependency management & build tool | Manage your libraries (like npm) | `npm` / `package.json` |
| **`pom.xml`** — Maven project config | Declare dependencies | `package.json` |
| **jpackage** (JDK 14+) — native packaging | Create `.exe`, `.dmg`, `.deb` installers | `electron-builder` |

### 9.7 Design & Theming

| What to Learn | Why You Need It | Current Equivalent |
|--------------|----------------|-------------------|
| **AtlantaFX** — modern JavaFX theme | Professional dark/light themes | Tailwind CSS |
| **Ikonli** — icon library for JavaFX | Icons for buttons, sidebar, etc. | Lucide React icons |
| **CSS variables in JavaFX** — custom properties | Color theming | Tailwind color palette |

---

## 10. Step-by-Step Learning Path (Build While Learning)

> **Philosophy:** Don't learn everything first. Learn a technology, then immediately use it in the project. Repeat.

---

### 📦 STEP 0: Setup Your Development Environment (Day 1)

**What to install:**
1. **JDK 21** (LTS) — [Download from Adoptium](https://adoptium.net/)
2. **IntelliJ IDEA Community** (free) — best Java IDE
3. **Scene Builder** — [Download from Gluon](https://gluonhq.com/products/scene-builder/)
4. **Maven** — usually bundled with IntelliJ

**What to learn:**
- How to create a Maven project in IntelliJ
- How `pom.xml` works (like `package.json`)
- How to add dependencies

**Verify setup:**
```bash
java --version    # Should show JDK 21
mvn --version     # Should show Maven 3.x
```

**Create your Maven project** with this `pom.xml` structure:
```xml
<project>
    <groupId>com.billingpro</groupId>
    <artifactId>desktop-billing-software</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <dependencies>
        <!-- Add dependencies step by step as you learn each tech -->
    </dependencies>
</project>
```

---

### 🖥️ STEP 1: Learn JavaFX Basics — Build the Window & Sidebar (Week 1)

**What to learn:**
- JavaFX Application class — `start(Stage primaryStage)`
- Stage (window), Scene (content), and basic Nodes
- Layouts: BorderPane, VBox, HBox
- FXML files and connecting them to Controller classes
- Basic CSS styling in JavaFX
- Button click handling

**What to build:**
- [ ] A main window (1400×900, minimum 1200×700)
- [ ] A left sidebar with 8 navigation buttons (Dashboard, Invoices, Quotations, Purchases, Customers, Products, Suppliers, Settings)
- [ ] A content area that switches when you click sidebar buttons
- [ ] Basic styling: dark sidebar, light content area

**Key concept — Page Navigation:**
In React, you use `<Route>` and `navigate()`. In JavaFX, you:
1. Create a `BorderPane` as the root layout
2. Sidebar goes in `setLeft()`
3. When a sidebar button is clicked, load a new FXML into `setCenter()`

**Dependencies to add:**
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>21</version>
</dependency>
```

---

### 🗄️ STEP 2: Learn JDBC + SQLite — Set Up the Database (Week 2)

**What to learn:**
- JDBC `Connection`, `Statement`, `PreparedStatement`, `ResultSet`
- How to connect to SQLite using `sqlite-jdbc`
- Creating tables with SQL (you already have the SQL from this document!)
- INSERT, SELECT, UPDATE, DELETE operations
- Closing connections properly (try-with-resources)

**What to build:**
- [ ] A `DatabaseManager` class that:
  - Creates the SQLite database file in the user's home directory
  - Creates ALL 13 tables (copy the SQL from Section 5)
  - Provides `getConnection()` method
- [ ] A `CounterDAO` class that handles auto-numbering (INV-0001, CUST-0001, etc.)

**Dependencies to add:**
```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.45.1.0</version>
</dependency>
```

**Test it:** Run the app → check if `billing.db` file is created with all tables.

---

### 👥 STEP 3: Build Customer Module — Your First Full CRUD (Week 3)

**What to learn:**
- JavaFX `TableView` with columns
- FXML forms with `TextField`, `ComboBox`, `TextArea`
- Data binding between Java objects and TableView
- The DAO (Data Access Object) pattern
- Form validation (required fields, GSTIN format)

**What to build:**
- [ ] `Customer.java` — model class (POJO) with all 14 fields from the table
- [ ] `CustomerDAO.java` — database operations:
  - `getAll()` → returns `List<Customer>`
  - `getById(int id)` → returns `Customer`
  - `create(Customer c)` → auto-generates CUST-XXXX code, uses transaction
  - `update(int id, Customer c)`
  - `delete(int id)`
- [ ] `CustomerListController.java` + `customer_list.fxml` — TableView showing all customers
- [ ] `CustomerFormController.java` + `customer_form.fxml` — form for add/edit
- [ ] Buttons: Add New, Edit, Delete with confirmation dialogs
- [ ] Indian states dropdown (ComboBox with all 37 states)

---

### 📦 STEP 4: Build Product Module with Stock Tracking (Week 4)

**What to learn:**
- More TableView features (cell formatting, conditional styling)
- Numeric input validation
- ComboBox for dropdowns (unit types, tax rates)
- Working with multiple tables (products + stock_history)

**What to build:**
- [ ] `Product.java` — model class
- [ ] `ProductDAO.java` — CRUD + soft delete (set `is_active = 0`)
- [ ] `StockService.java` — port the entire stock.service.ts:
  - `adjustStock()`, `setOpeningStock()`, `getStockHistory()`
  - `getLowStockProducts()`, `reverseStockMovements()`
  - `processInvoiceStock()`, `processPurchaseStock()`
- [ ] Product list page with TableView
- [ ] Product form with opening stock
- [ ] Stock history view (maybe a popup/dialog)
- [ ] Low stock indicator (highlight rows in red)

---

### 🚛 STEP 5: Build Supplier Module (Week 4, continued)

**What to build** (simpler version of Customer module):
- [ ] `Supplier.java`, `SupplierDAO.java`
- [ ] Supplier list and form pages
- [ ] Soft delete support

---

### 🧾 STEP 6: Build Invoice Module — The Big One (Week 5-6)

**What to learn:**
- Complex forms with dynamic rows (add/remove line items)
- Master-detail pattern (invoice header + line items)
- ComboBox with search/filter for customer selection
- Calculated fields that update in real-time
- Database transactions (invoice + items must save atomically)

**What to build:**
- [ ] `Invoice.java`, `InvoiceItem.java` — model classes
- [ ] `InvoiceDAO.java`:
  - `getAll()` with JOIN to customers
  - `getById()` with items and customer details
  - `create()` — auto-number + insert items + stock deduction (transaction)
  - `update()` — reverse stock → update → new stock (transaction)
  - `delete()` — reverse stock → delete
  - `cancel()` — reverse stock → mark cancelled
- [ ] GST calculation logic (port `gst.ts`):
  - `isInterstate()` — compare company state vs customer state
  - `calculateItemGST()` — compute CGST/SGST or IGST
  - `calculateInvoiceTotals()` — subtotal, taxes, round-off, grand total
- [ ] Create Invoice page:
  - Customer dropdown (with state info for GST)
  - Date pickers for invoice date and due date
  - Place of supply dropdown
  - Dynamic item rows: product selection, qty, price, discount, calculated amounts
  - Live-updating tax summary
  - Transportation charges, round-off
  - Notes and T&C text areas
- [ ] Invoice list page with status/payment badges
- [ ] View Invoice page (read-only formatted view)
- [ ] Edit Invoice page (pre-populated form)

---

### 📋 STEP 7: Build Quotation Module (Week 7)

**What to build** (very similar to Invoice):
- [ ] `Quotation.java`, `QuotationItem.java`, `QuotationDAO.java`
- [ ] All CRUD operations
- [ ] **Convert to Invoice** feature — the key differentiator:
  - Copy quotation data → create invoice → mark quotation as accepted
- [ ] Different status workflow: Draft → Sent → Accepted/Rejected/Expired

---

### 🛒 STEP 8: Build Purchase Module (Week 7, continued)

**What to build** (supplier-side version of Invoice):
- [ ] `Purchase.java`, `PurchaseItem.java`, `PurchaseDAO.java`
- [ ] Stock ADDITION on purchase create (opposite of invoice)
- [ ] Supplier's invoice number field

---

### 📊 STEP 9: Build Dashboard (Week 8)

**What to learn:**
- JavaFX Charts API: BarChart, LineChart
- Complex SQL aggregation queries
- Layout design with multiple cards

**What to build:**
- [ ] `AnalyticsDAO.java` — port all the dashboard queries:
  - Total revenue, invoice counts, unpaid stats
  - This month's stats
  - Quotation breakdown
  - Customer/product counts
  - 6-month trend data
- [ ] Dashboard page:
  - 4 stat cards (Revenue, Invoices, Unpaid, Customers)
  - Low stock alert section
  - Quotation overview (Draft/Sent/Accepted counts)
  - Quick action buttons
  - Optional: Monthly revenue chart

---

### 📄 STEP 10: PDF Generation (Week 8-9)

**What to learn:**
- iText 7 basics: Document, Paragraph, Table, Cell
- Adding images to PDFs
- Fonts, colors, borders in iText
- Indian number-to-words conversion (port from `numberToWords()`)

**What to build:**
- [ ] `PDFService.java`:
  - `generateInvoicePDF(int invoiceId)` — A4 layout with:
    - Company header (logo, name, GSTIN, address)
    - Customer details
    - Item table with all columns
    - Tax summary (CGST/SGST or IGST)
    - Amount in words
    - Signature section
  - `generateQuotationPDF(int quotationId)` — green-themed version
- [ ] Auto-open PDF after saving (using `Desktop.getDesktop().open(file)`)

**Dependencies:**
```xml
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itext7-core</artifactId>
    <version>8.0.2</version>
    <type>pom</type>
</dependency>
```

---

### 📊 STEP 11: Excel Export (Week 9)

**What to learn:**
- Apache POI basics: Workbook, Sheet, Row, Cell
- Cell styling (bold headers)
- JavaFX FileChooser dialog

**What to build:**
- [ ] `ExcelService.java`:
  - `exportInvoices()` — all invoices to .xlsx
  - `exportPurchases()` — all purchases to .xlsx
- [ ] Save dialog using JavaFX `FileChooser`

**Dependencies:**
```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
```

---

### ⚙️ STEP 12: Settings & Admin Panel (Week 9-10)

**What to build:**
- [ ] `SettingsDAO.java` — key-value settings storage
- [ ] Settings page: company info, logo upload, document prefixes, T&C
- [ ] Logo upload with JavaFX `FileChooser` + image preview
- [ ] Admin panel with password protection:
  - Login form
  - Change password
  - Recovery code system
  - Database statistics

---

### 🔔 STEP 13: Notifications (Week 10)

**What to build:**
- [ ] `NotificationService.java`:
  - Low stock alerts
  - Unpaid invoice alerts
  - Pending quotation alerts
- [ ] Notification bell in header with count badge
- [ ] Notification dropdown panel

---

### 🎨 STEP 14: Polish & Theme (Week 10-11)

**What to learn:**
- AtlantaFX theme integration
- Ikonli icon library for JavaFX
- Custom CSS styling

**What to do:**
- [ ] Add AtlantaFX theme for professional look
- [ ] Add icons throughout the app using Ikonli
- [ ] Color-code sections (blue for invoices, green for quotations, teal for purchases)
- [ ] Add loading spinners, hover effects
- [ ] Test all features end-to-end

**Dependencies:**
```xml
<dependency>
    <groupId>io.github.mkpaz</groupId>
    <artifactId>atlantafx-base</artifactId>
    <version>2.0.1</version>
</dependency>
<dependency>
    <groupId>org.kordamp.ikonli</groupId>
    <artifactId>ikonli-javafx</artifactId>
    <version>12.3.1</version>
</dependency>
<dependency>
    <groupId>org.kordamp.ikonli</groupId>
    <artifactId>ikonli-feather-pack</artifactId>
    <version>12.3.1</version>
</dependency>
```

---

### 📦 STEP 15: Package for Distribution (Week 11)

**What to learn:**
- `jpackage` tool (comes with JDK 14+)
- Creating native installers

**Commands:**
```bash
# Windows (.exe installer)
jpackage --input target/ --name "Billing Pro" --main-jar billing-software.jar \
  --type exe --icon icon.ico --app-version 1.0.0

# Linux (.deb installer)
jpackage --input target/ --name "Billing Pro" --main-jar billing-software.jar \
  --type deb --icon icon.png --app-version 1.0.0

# macOS (.dmg installer)
jpackage --input target/ --name "Billing Pro" --main-jar billing-software.jar \
  --type dmg --icon icon.icns --app-version 1.0.0
```

---

## 11. Java Project Structure

```
desktop-billing-software-java/
├── pom.xml                          # Maven config (like package.json)
├── src/
│   └── main/
│       ├── java/
│       │   └── com/billingpro/
│       │       ├── App.java                    # Main entry point
│       │       ├── database/
│       │       │   └── DatabaseManager.java    # DB connection & table creation
│       │       ├── model/                      # POJOs (data classes)
│       │       │   ├── Customer.java
│       │       │   ├── Product.java
│       │       │   ├── Supplier.java
│       │       │   ├── Invoice.java
│       │       │   ├── InvoiceItem.java
│       │       │   ├── Quotation.java
│       │       │   ├── QuotationItem.java
│       │       │   ├── Purchase.java
│       │       │   ├── PurchaseItem.java
│       │       │   ├── StockMovement.java
│       │       │   ├── Setting.java
│       │       │   └── Notification.java
│       │       ├── dao/                        # Database operations
│       │       │   ├── CustomerDAO.java
│       │       │   ├── ProductDAO.java
│       │       │   ├── SupplierDAO.java
│       │       │   ├── InvoiceDAO.java
│       │       │   ├── QuotationDAO.java
│       │       │   ├── PurchaseDAO.java
│       │       │   ├── SettingsDAO.java
│       │       │   ├── AnalyticsDAO.java
│       │       │   └── CounterDAO.java
│       │       ├── service/                    # Business logic
│       │       │   ├── GSTService.java         # Tax calculations
│       │       │   ├── StockService.java       # Inventory management
│       │       │   ├── PDFService.java         # PDF generation
│       │       │   ├── ExcelService.java       # Excel export
│       │       │   ├── NotificationService.java
│       │       │   └── NumberToWordsService.java
│       │       ├── controller/                 # JavaFX controllers
│       │       │   ├── MainController.java     # Sidebar + navigation
│       │       │   ├── DashboardController.java
│       │       │   ├── CustomerListController.java
│       │       │   ├── CustomerFormController.java
│       │       │   ├── ProductListController.java
│       │       │   ├── ProductFormController.java
│       │       │   ├── InvoiceListController.java
│       │       │   ├── InvoiceFormController.java
│       │       │   ├── InvoiceViewController.java
│       │       │   ├── QuotationListController.java
│       │       │   ├── QuotationFormController.java
│       │       │   ├── PurchaseListController.java
│       │       │   ├── PurchaseFormController.java
│       │       │   ├── SupplierListController.java
│       │       │   ├── SettingsController.java
│       │       │   └── AdminController.java
│       │       └── util/                       # Utilities
│       │           ├── Constants.java          # Indian states, units, tax rates
│       │           ├── CurrencyFormatter.java
│       │           └── DateUtils.java
│       └── resources/
│           ├── fxml/                           # UI layouts
│           │   ├── main.fxml
│           │   ├── sidebar.fxml
│           │   ├── dashboard.fxml
│           │   ├── customer_list.fxml
│           │   ├── customer_form.fxml
│           │   ├── product_list.fxml
│           │   ├── invoice_list.fxml
│           │   ├── invoice_form.fxml
│           │   ├── invoice_view.fxml
│           │   ├── quotation_list.fxml
│           │   ├── purchase_list.fxml
│           │   ├── settings.fxml
│           │   └── admin.fxml
│           ├── css/
│           │   └── styles.css                  # Custom styles
│           └── images/
│               └── icon.png
└── target/                                     # Build output (like 'out/')
```

---

## 12. File-by-File Mapping (Current → Java)

| Current File (TypeScript) | Java Equivalent | Notes |
|--------------------------|----------------|-------|
| `src/main/index.ts` | `App.java` | Entry point, creates window |
| `src/main/database/index.ts` | `DatabaseManager.java` | DB init + all 13 table creation |
| `src/main/ipc/customer.handler.ts` | `CustomerDAO.java` | CRUD operations |
| `src/main/ipc/product.handler.ts` | `ProductDAO.java` | CRUD + stock handlers |
| `src/main/ipc/supplier.handler.ts` | `SupplierDAO.java` | CRUD operations |
| `src/main/ipc/invoice.handler.ts` | `InvoiceDAO.java` | CRUD + stock integration |
| `src/main/ipc/quotation.handler.ts` | `QuotationDAO.java` | CRUD + convert to invoice |
| `src/main/ipc/purchase.handler.ts` | `PurchaseDAO.java` | CRUD + stock integration |
| `src/main/ipc/analytics.handler.ts` | `AnalyticsDAO.java` | Dashboard queries |
| `src/main/ipc/settings.handler.ts` | `SettingsDAO.java` | Settings + auth + logo |
| `src/main/ipc/pdf.handler.ts` | `PDFService.java` | iText PDF generation |
| `src/main/ipc/excel.handler.ts` | `ExcelService.java` | Apache POI export |
| `src/main/ipc/notifications.handler.ts` | `NotificationService.java` | Alert queries |
| `src/main/services/stock.service.ts` | `StockService.java` | Stock management |
| `src/main/services/updater.ts` | *(Optional)* | Can add later |
| `src/shared/constants/index.ts` | `Constants.java` | States, units, tax rates |
| `src/shared/constants/gst.ts` | `GSTService.java` | GST calculation logic |
| `src/preload/index.ts` | *(Not needed)* | Java doesn't need IPC bridge |
| `src/renderer/App.tsx` | `MainController.java` | Navigation/routing |
| `src/renderer/components/layout/Sidebar.tsx` | Part of `main.fxml` | Sidebar UI |
| `src/renderer/components/layout/Header.tsx` | Part of `main.fxml` | Header UI |
| `src/renderer/pages/Dashboard.tsx` | `DashboardController.java` + `dashboard.fxml` | Dashboard page |
| `src/renderer/pages/Settings.tsx` | `SettingsController.java` + `settings.fxml` | Settings page |
| `src/renderer/pages/Admin.tsx` | `AdminController.java` + `admin.fxml` | Admin panel |
| Each page in `pages/Invoices/` | Corresponding controller + FXML | Invoice pages |
| Each page in `pages/Quotations/` | Corresponding controller + FXML | Quotation pages |
| Each page in `pages/Purchases/` | Corresponding controller + FXML | Purchase pages |
| `tailwind.config.js` | `styles.css` + AtlantaFX | Styling |
| `package.json` | `pom.xml` | Dependencies |
| `electron.vite.config.ts` | Maven build | Build config |

---

> **Remember:** You don't need to learn all of this before starting. Follow the step-by-step path:
> **Learn one thing → Build that part → Move to the next.**
> 
> The business logic (GST calculations, stock management, numbering) is **the same in any language**.
> Only the tools around it change.
>
> Good luck with your Java journey! 🚀
