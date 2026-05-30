# AI=Expense-Tracker Backend

AI-powered Expense & Finance Tracker built using FastAPI, PostgreSQL, OCR, and Gemini AI.

---

# Overview

ExpenseVision AI is a smart finance management backend that allows users to:

* Upload receipt images
* Extract text using OCR
* Automatically categorize expenses
* Store expenses in PostgreSQL
* Generate analytics and trends
* Ask finance-related questions using AI

The project combines:

* OCR (Optical Character Recognition)
* FastAPI backend architecture
* PostgreSQL database management
* Gemini AI integration
* Receipt automation pipelines

---

# Tech Stack

| Technology       | Purpose          |
| ---------------- | ---------------- |
| Python           | Backend language |
| FastAPI          | API framework    |
| PostgreSQL       | Database         |
| SQLAlchemy       | ORM              |
| Tesseract OCR    | Text extraction  |
| Pillow           | Image processing |
| Gemini 2.5 Flash | AI analysis      |
| Pydantic         | Data validation  |
| JWT              | Authentication   |

---

# Core Workflow

```text
Receipt Image
      ↓
OCR Extraction
      ↓
Gemini AI Analysis
      ↓
Structured Expense Data
      ↓
PostgreSQL Database
      ↓
Analytics + AI Insights
```

---

# Important Concepts

# 1. OCR (Optical Character Recognition)

OCR is a technology that converts images containing text into machine-readable text.

Example:

Receipt Image:

```text
STARBUCKS

Latte     220
Cookie     80

TOTAL     300
```

OCR Output:

```text
STARBUCKS
Latte 220
Cookie 80
TOTAL 300
```

In this project, OCR is used to automate receipt reading.

---

# 2. Tesseract OCR

Tesseract is an open-source OCR engine developed by Google.

It performs:

* Character detection
* Word recognition
* Text extraction

The project uses:

```python
pytesseract
```

which is a Python wrapper around the Tesseract engine.

Example:

```python
text = pytesseract.image_to_string(image)
```

---

# 3. Pillow (PIL)

Pillow is a Python image processing library.

Used for:

* Opening images
* Reading image files
* Preparing images for OCR

Example:

```python
from PIL import Image

image = Image.open("receipt.jpg")
```


Example:

OCR Text:

```text
DOMINOS
Pizza 499
Tax 46
TOTAL 545
```

Gemini Output:

```json
{
  "merchant":"Dominos",
  "amount":545,
  "category":"Food"
}
```

---

# Project Structure

```text
expensevision-ai-backend/
│
├── app/
│   ├── main.py
│   │
│   ├── config/
│   │   ├── database.py
│   │   └── settings.py
│   │
│   ├── models/
│   │   ├── user.py
│   │   ├── expense.py
│   │   ├── receipt.py
│   │   └── budget.py
│   │
│   ├── routes/
│   │   ├── auth.py
│   │   ├── expenses.py
│   │   ├── receipts.py
│   │   ├── insights.py
│   │   └── chat.py
│   │
│   ├── services/
│   │   ├── ocr_service.py
│   │   ├── gemini_service.py
│   │   ├── analytics_service.py
│   │   └── budget_service.py
│   │
│   └── utils/
│       └── auth.py
│
├── uploads/
├── requirements.txt
├── .env
└── README.md
```

---

# Installation

# 1. Clone Repository

```bash
git clone git@github-personal:VanshiGala/ai-expense-tracker.git
```

---

# 2. Create Virtual Environment

```bash
python -m venv .venv
```

Activate:

Windows:

```bash
.venv\Scripts\activate
```

---

# 3. Install Dependencies

```bash
pip install -r requirements.txt
```

---

# 4. Install Tesseract OCR

Download:

https://github.com/UB-Mannheim/tesseract/wiki

Install to:

```text
C:\\Program Files\\Tesseract-OCR\\
```

Verify:

```bash
tesseract --version
```

---

# 5. Configure Environment Variables

Create `.env`

```env
DB_USER=postgres
DB_PASSWORD=password
DB_HOST=localhost
DB_PORT=5432
DB_NAME=expense_tracker

JWT_SECRET=supersecret
ALGORITHM=HS256

GEMINI_API_KEY=your_api_key

OCR_PATH=C:\\Program Files\\Tesseract-OCR\\tesseract.exe
```

---

# 6. Run Server

```bash
uvicorn app.main:app --reload
```

---

# API Documentation

FastAPI automatically generates Swagger docs.

Open:

```text
http://127.0.0.1:8000/docs
```

---

# Example APIs

# Upload Receipt

```http
POST /receipts/upload
```

Upload image using form-data.

---

# Create Expense

```http
POST /expenses/
```

```json
{
  "title":"Coffee",
  "amount":250,
  "category":"Food",
  "merchant":"Starbucks"
}
```

---

# AI Finance Chat

```http
POST /chat/
```

```json
{
  "question":"How much did I spend on food?"
}
```
