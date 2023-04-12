package com.lear.exception;

/**
 * 牌堆空异常
 * @author 天狗
 */
public class CardDeckEmptyException extends RuntimeException {

        public CardDeckEmptyException() {
            super();
        }

        public CardDeckEmptyException(String message) {
            super(message);
        }

        public CardDeckEmptyException(String message, Throwable cause) {
            super(message, cause);
        }

        public CardDeckEmptyException(Throwable cause) {
            super(cause);
        }

        protected CardDeckEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
