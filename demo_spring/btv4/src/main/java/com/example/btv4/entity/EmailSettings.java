package com.example.btv4.entity;

    public class Mail {
        private String language;
        private int pageSize;
        private boolean spamsFilter;
        private String signature;

        public Mail(String language, int pageSize, boolean spamsFilter, String signature) {
            this.language = language;
            this.pageSize = pageSize;
            this.spamsFilter = spamsFilter;
            this.signature = signature;
        }

        public Mail() {
        }

        // getter & setter
        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public boolean isSpamsFilter() {
            return spamsFilter;
        }

        public void setSpamsFilter(boolean spamsFilter) {
            this.spamsFilter = spamsFilter;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }
    }


