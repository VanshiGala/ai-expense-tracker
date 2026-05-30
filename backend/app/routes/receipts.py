import os

from fastapi import APIRouter
from fastapi import File
from fastapi import UploadFile

from app.services.ocr import extract_text
from app.services.gemini import analyze_receipt


router = APIRouter(prefix="/receipts", tags=["Receipts"])


UPLOAD_DIR = "uploads"

os.makedirs(UPLOAD_DIR, exist_ok=True)


@router.post("/upload")
async def upload_receipt(file: UploadFile = File(...)):

    file_path = f"{UPLOAD_DIR}/{file.filename}"

    with open(file_path, "wb") as buffer:
        buffer.write(await file.read())

    extracted_text = extract_text(file_path)

    ai_response = analyze_receipt(extracted_text)

    return {
        "ocr_text": extracted_text,
        "ai_analysis": ai_response
    }