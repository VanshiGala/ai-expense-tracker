import google.generativeai as genai

from app.config.settings import settings


genai.configure(api_key=settings.GEMINI_API_KEY)

model = genai.GenerativeModel("gemini-2.5-flash")



def analyze_receipt(text: str):

    prompt = f"""
    Extract the following from this receipt:

    - merchant
    - amount
    - category

    Return JSON only.

    Receipt:
    {text}
    """

    response = model.generate_content(prompt)

    return response.text