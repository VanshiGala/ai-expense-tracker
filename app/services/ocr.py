import pytesseract

from PIL import Image

from app.config.settings import settings #loads env

#OCR path
pytesseract.pytesseract.tesseract_cmd = settings.OCR_PATH



def extract_text(image_path: str):
    image = Image.open(image_path)

    text = pytesseract.image_to_string(image)

    return text