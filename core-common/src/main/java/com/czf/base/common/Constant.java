package com.czf.base.common;

/**
 * 枚举常量
 */
public class Constant {

    /**
     * 超级用户
     */
    public static final String SUPERR_USER="026a564bbfd84861ac4b65393644beef";

    /**
     * 系统默认密码
     */
    public static final String DEF_PASSWORD="a";

    /**
     * 返回状态值
     */
    public enum RESULT {
        /**
         * 成功
         */
        CODE_YES("0"),
        /**
         * 失败
         */
        CODE_NO("-1"),
        /**
         * 成功msg
         */
        MSG_YES("操作成功"),
        /**
         * 失败
         */
        MSG_NO("操作失败");

        private String value;
        private RESULT(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    /**
     * 菜单类型
     */
    public enum MenuType{
        /**
         * 菜单
         */
        MENU("1"),
        /**
         * 按钮
         */
        BUTTON("2"),
        /**
         * 目录
         */
        CATALOG("0");
        private String value;

        private MenuType(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }

    /**
     * 是否类型
     */
    public enum YESNO {
        /**
         * 是
         */
        YES("0"),
        /**
         * 否
         */
        NO("1");

        private String value;

        private YESNO(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum ABLE_STATUS {
        /**
         * 正常
         */
        YES("0"),
        /**
         * 禁用
         */
        NO("-1");
        private String value;

        ABLE_STATUS(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }

    /**
     * 机构类型
     */
    public enum OrganType {
        /**
         * 根节点
         */
        CATALOG("0"),
        /**
         * 机构
         */
        ORGAN("1"),
        /**
         * 部门
         */
        DEPART("2");

        private String value;

        private OrganType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
