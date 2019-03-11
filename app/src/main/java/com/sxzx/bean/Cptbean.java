package com.sxzx.bean;

import java.util.List;

public class Cptbean {


    /**
     * error_code : 0
     * msg : 获取成功
     * teachingBuilding : 第一教学楼
     * lab : 1202
     * maxCols : 12
     * computers : [{"computer_id":61,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":1,"type":1,"status":1},{"computer_id":62,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":2,"type":1,"status":1},{"computer_id":63,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":3,"type":1,"status":1},{"computer_id":64,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":4,"type":1,"status":1},{"computer_id":65,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":5,"type":1,"status":1},{"computer_id":66,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":6,"type":1,"status":1},{"computer_id":67,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":7,"type":1,"status":1},{"computer_id":68,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":8,"type":1,"status":1},{"computer_id":69,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":9,"type":1,"status":1},{"computer_id":70,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":10,"type":1,"status":1},{"computer_id":71,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":11,"type":1,"status":1},{"computer_id":72,"tb_id":1,"lab_id":2,"computer_row":1,"computer_col":12,"type":1,"status":1},{"computer_id":73,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":1,"type":1,"status":1},{"computer_id":74,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":2,"type":1,"status":1},{"computer_id":75,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":3,"type":1,"status":1},{"computer_id":76,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":4,"type":1,"status":1},{"computer_id":77,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":5,"type":1,"status":1},{"computer_id":78,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":6,"type":1,"status":1},{"computer_id":79,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":7,"type":1,"status":1},{"computer_id":80,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":8,"type":1,"status":1},{"computer_id":81,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":9,"type":1,"status":1},{"computer_id":82,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":10,"type":1,"status":1},{"computer_id":83,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":11,"type":1,"status":1},{"computer_id":84,"tb_id":1,"lab_id":2,"computer_row":2,"computer_col":12,"type":1,"status":1},{"computer_id":85,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":1,"type":1,"status":1},{"computer_id":86,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":2,"type":1,"status":1},{"computer_id":87,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":3,"type":1,"status":1},{"computer_id":88,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":4,"type":1,"status":1},{"computer_id":89,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":5,"type":1,"status":1},{"computer_id":90,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":6,"type":1,"status":1},{"computer_id":91,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":7,"type":1,"status":1},{"computer_id":92,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":8,"type":1,"status":1},{"computer_id":93,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":9,"type":1,"status":1},{"computer_id":94,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":10,"type":1,"status":1},{"computer_id":95,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":11,"type":1,"status":1},{"computer_id":96,"tb_id":1,"lab_id":2,"computer_row":3,"computer_col":12,"type":2,"status":1},{"computer_id":97,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":1,"type":1,"status":1},{"computer_id":98,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":2,"type":1,"status":1},{"computer_id":99,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":3,"type":1,"status":1},{"computer_id":100,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":4,"type":1,"status":1},{"computer_id":101,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":5,"type":1,"status":1},{"computer_id":102,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":6,"type":1,"status":1},{"computer_id":103,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":7,"type":1,"status":1},{"computer_id":104,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":8,"type":1,"status":1},{"computer_id":105,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":9,"type":1,"status":1},{"computer_id":106,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":10,"type":1,"status":1},{"computer_id":107,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":11,"type":1,"status":1},{"computer_id":108,"tb_id":1,"lab_id":2,"computer_row":4,"computer_col":12,"type":1,"status":1},{"computer_id":109,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":1,"type":1,"status":1},{"computer_id":110,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":2,"type":1,"status":1},{"computer_id":111,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":3,"type":1,"status":1},{"computer_id":112,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":4,"type":1,"status":1},{"computer_id":113,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":5,"type":1,"status":1},{"computer_id":114,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":6,"type":1,"status":1},{"computer_id":115,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":7,"type":1,"status":1},{"computer_id":116,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":8,"type":1,"status":1},{"computer_id":117,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":9,"type":1,"status":1},{"computer_id":118,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":10,"type":1,"status":1},{"computer_id":119,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":11,"type":1,"status":1},{"computer_id":120,"tb_id":1,"lab_id":2,"computer_row":5,"computer_col":12,"type":1,"status":2}]
     */

    private int error_code;
    private String msg;
    private String teachingBuilding;
    private String lab;
    private int maxCols;
    private List<ComputersBean> computers;

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

    public String getTeachingBuilding() {
        return teachingBuilding;
    }

    public void setTeachingBuilding(String teachingBuilding) {
        this.teachingBuilding = teachingBuilding;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public int getMaxCols() {
        return maxCols;
    }

    public void setMaxCols(int maxCols) {
        this.maxCols = maxCols;
    }

    public List<ComputersBean> getComputers() {
        return computers;
    }

    public void setComputers(List<ComputersBean> computers) {
        this.computers = computers;
    }

    public static class ComputersBean {
        /**
         * computer_id : 61
         * tb_id : 1
         * lab_id : 2
         * computer_row : 1
         * computer_col : 1
         * type : 1
         * status : 1
         */

        private int computer_id;
        private int tb_id;
        private int lab_id;
        private int computer_row;
        private int computer_col;
        private int type;
        private int status;

        public int getComputer_id() {
            return computer_id;
        }

        public void setComputer_id(int computer_id) {
            this.computer_id = computer_id;
        }

        public int getTb_id() {
            return tb_id;
        }

        public void setTb_id(int tb_id) {
            this.tb_id = tb_id;
        }

        public int getLab_id() {
            return lab_id;
        }

        public void setLab_id(int lab_id) {
            this.lab_id = lab_id;
        }

        public int getComputer_row() {
            return computer_row;
        }

        public void setComputer_row(int computer_row) {
            this.computer_row = computer_row;
        }

        public int getComputer_col() {
            return computer_col;
        }

        public void setComputer_col(int computer_col) {
            this.computer_col = computer_col;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
