from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from app.config.db import Base
from app.config.db import engine

from app.routes import auth
from app.routes import expenses
from app.routes import receipts
from app.routes import insights
from app.routes import chat


Base.metadata.create_all(bind=engine)

app = FastAPI(title="ExpenseVision AI")


app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


app.include_router(auth.router)
app.include_router(expenses.router)
app.include_router(receipts.router)
app.include_router(insights.router)
app.include_router(chat.router)


@app.get("/")
def root():
    return {
        "message": "ai-expense-tracker Backend Running"
    }