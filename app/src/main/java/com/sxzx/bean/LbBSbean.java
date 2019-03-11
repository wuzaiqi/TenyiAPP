package com.sxzx.bean;

import java.util.List;

//获取机房bean
public class LbBSbean {


    /**
     * error_code : 0
     * msg : 获取成功
     * labs : [{"lab_id":5,"tb_id":2,"sort":25,"lab_name":"3209","display":1,"tb_name":"第三教学楼"}]
     */

    private int error_code;
    private String msg;
    private List<LabsBean> labs;

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

    public List<LabsBean> getLabs() {
        return labs;
    }

    public void setLabs(List<LabsBean> labs) {
        this.labs = labs;
    }

    public static class LabsBean {
        /**
         * lab_id : 5
         * tb_id : 2
         * sort : 25
         * lab_name : 3209
         * display : 1
         * tb_name : 第三教学楼
         */

        private int lab_id;
        private int tb_id;
        private int sort;
        private String lab_name;
        private int display;
        private String tb_name;

        public int getLab_id() {
            return lab_id;
        }

        public void setLab_id(int lab_id) {
            this.lab_id = lab_id;
        }

        public int getTb_id() {
            return tb_id;
        }

        public void setTb_id(int tb_id) {
            this.tb_id = tb_id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getLab_name() {
            return lab_name;
        }

        public void setLab_name(String lab_name) {
            this.lab_name = lab_name;
        }

        public int getDisplay() {
            return display;
        }

        public void setDisplay(int display) {
            this.display = display;
        }

        public String getTb_name() {
            return tb_name;
        }

        public void setTb_name(String tb_name) {
            this.tb_name = tb_name;
        }
    }
}
