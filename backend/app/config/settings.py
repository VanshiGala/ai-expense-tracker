from pydantic_settings import BaseSettings


class Settings(BaseSettings):
    DB_USER: str
    DB_PASSWORD: str
    DB_HOST: str
    DB_PORT: str
    DB_NAME: str
    JWT_SECRET: str
    ALGORITHM: str
    GEMINI_API_KEY: str
    OCR_PATH: str

    class Config:
        env_file = ".env"

    @property
    def DATABASE_URL(self):
        return (
            f"postgresql://{self.DB_USER}:"
            f"{self.DB_PASSWORD}@"
            f"{self.DB_HOST}:"
            f"{self.DB_PORT}/"
            f"{self.DB_NAME}"
        )



settings = Settings()