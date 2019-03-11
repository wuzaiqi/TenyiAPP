package com.sxzx.bean;

import java.util.List;

//获取故障类型Bean
public class FAULTSBean {

    /**
     * error_code : 0
     * msg : 获取成功
     * faultsList : [{"fault_id":1,"sort":10,"fault_type":"显示器"},{"fault_id":2,"sort":20,"fault_type":"网络"},{"fault_id":4,"sort":30,"fault_type":"主机"},{"fault_id":3,"sort":50,"fault_type":"软件"},{"fault_id":5,"sort":100,"fault_type":"其他"}]
     */

    private int error_code;
    private String msg;
    private List<FaultsListBean> faultsList;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<FaultsListBean> getFaultsList() {
        return faultsList;
    }

    public void setFaultsList(List<FaultsListBean> faultsList) {
        this.faultsList = faultsList;
    }

    public static class FaultsListBean {
        /**
         * fault_id : 1
         * sort : 10
         * fault_type : 显示器
         */

        private int fault_id;
        private int sort;
        private String fault_type;

        public int getFault_id() {
            return fault_id;
        }

        public void setFault_id(int fault_id) {
            this.fault_id = fault_id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getFault_type() {
            return fault_type;
        }

        public void setFault_type(String fault_type) {
            this.fault_type = fault_type;
        }
    }
}
