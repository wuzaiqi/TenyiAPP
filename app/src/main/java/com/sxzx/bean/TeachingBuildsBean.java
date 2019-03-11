package com.sxzx.bean;

import java.util.List;

//获取教学楼Bean
public class TeachingBuildsBean {

    /**
     * error_code : 0
     * msg : 获取成功
     * teachingBuildings : [{"tb_id":1,"sort":10,"tb_name":"第一教学楼","display":1},{"tb_id":2,"sort":20,"tb_name":"第三教学楼","display":1}]
     */

    private int error_code;
    private String msg;
    private List<TeachingBuildingsBean> teachingBuildings;

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

    public List<TeachingBuildingsBean> getTeachingBuildings() {
        return teachingBuildings;
    }

    public void setTeachingBuildings(List<TeachingBuildingsBean> teachingBuildings) {
        this.teachingBuildings = teachingBuildings;
    }

    public static class TeachingBuildingsBean {
        /**
         * tb_id : 1
         * sort : 10
         * tb_name : 第一教学楼
         * display : 1
         */

        private int tb_id;
        private int sort;
        private String tb_name;
        private int display;

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

        public String getTb_name() {
            return tb_name;
        }

        public void setTb_name(String tb_name) {
            this.tb_name = tb_name;
        }

        public int getDisplay() {
            return display;
        }

        public void setDisplay(int display) {
            this.display = display;
        }
    }
}
