package com.lear.exception;

/**
 * 收牌不可用异常
 */
public class SaveCardUnavailableException extends RuntimeException{

        public SaveCardUnavailableException() {
            super();
        }

        public SaveCardUnavailableException(String message) {
            super(message);
        }

        public SaveCardUnavailableException(String message, Throwable cause) {
            super(message, cause);
        }

        public SaveCardUnavailableException(Throwable cause) {
            super(cause);
        }

        protected SaveCardUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
