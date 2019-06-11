package enumdemo;

/**
 * Created by duizhuang on 5/14/2019.
 */
public class EnumDemo2 {
    public enum ProcessStatusEnum {
        未支付((short) 0, "未支付", "加工订单已提交，等待付款", "", "待付款", Short.valueOf("1"), "待付款"),
        客服审核中((short) 5, "客服审核中", "客服审核中", "", "待审核", Short.valueOf("2"), "待客服审核"),
        客服初审不通过财务退款中((short) 10, "客服初审不通过财务退款中", "审核未通过，等待退款", "", "待退预估价", Short.valueOf("-1"), "待退预估费用"),
        客服初审不通过退款成功((short) 15, "客服初审不通过财务退款成功", "退款成功", "", "已完成", Short.valueOf("-2"), "已取消"),
        客服初审通过等待客户发货((short) 20, "客服初审通过等待客户发货", "审核已通过，等待寄回对庄", "", "待寄回对庄", Short.valueOf("3"), "待寄回对庄"),
        客户已发货((short) 25, "客户已发货", "等待对庄收货", "", "待对庄收货", Short.valueOf("3"), "待寄回对庄"),
        客户发货对庄收到((short) 30, "对庄已收货", "对庄已收货，正在送往鉴定中心检测", "", "待检测宝贝", Short.valueOf("4"), "待检测宝贝"),
        检测未通过等待发回((short) 35, "检测不通过等待发回", "检测未通过，等待退货", "", "待对庄发货", Short.valueOf("12"), "检测未通过等待发回"),
        检测未通过已发回((short) 40, "检测未通过,已发回", "等待收货", "", "待买家收货", Short.valueOf("13"), "待买家收货"),
        检测未通过财务退款中((short) 45, "检测未通过,财务退款中", "检测未通过，等待退款", "", "待退预估价", Short.valueOf("-1"), "待退预估费用"),
        检测未通过退款成功((short) 50, "检测未通过,退款成功", "退款成功", "", "已完成", Short.valueOf("-2"), "已取消"),
        检测通过待发货给工厂((short) 55, "对庄已收货", "对庄已收货，正在送往鉴定中心检测", "", "待检测宝贝", Short.valueOf("5"), "待对庄发货给工厂"),
        已发货给工厂((short) 60, "对庄检测并发货给工厂", "检测已通过，对庄已把宝贝发往工厂", "您有加工订单，请注意查收", "待工厂收货", Short.valueOf("6"), "待工厂收货"),
        工厂收货加工中((short) 65, "工厂收货加工中", "工厂已收货，正在加工中", "正在加工中", "待工厂发货", Short.valueOf("7"), "工厂收货加工中"),
        工厂已发货((short) 70, "工厂发货", "加工完成，等待对庄收货", "加工完成，等待对庄收货", "待对庄收加工完成宝贝", Short.valueOf("8"), "对庄已收货送检中"),
        对庄已收货送检中((short) 75, "对庄已收货送检中", "对庄已收货，正在送往鉴定中心检测", "对庄已收货，正在送往鉴定中心检测", "待鉴定加工宝贝", Short.valueOf("9"), "对庄已收货送检中"),
        检测通过待退差((short) 80, "检测通过待退差", "检测通过，费用清单已出，待退差价", "检测通过，待退差价", "待退差价", Short.valueOf("10"), "检测通过待退差"),
        检测通过待补差((short) 85, "检测通过待补差", "检测通过，费用清单已出，待补差价", "检测通过，待补差价", "待补差价", Short.valueOf("11"), "检测通过待补差"),
        检测通过等待对庄发货((short) 90, "检测通过等待对庄发货", "鉴定检测通过，等待对庄发货", "鉴定检测通过，等待对庄发货", "待发货给买家", Short.valueOf("12"), "待发货给买家"),
        客户已补差价等待对庄发货((short) 95, "客户已补差价", "差价已补齐，等待对庄发货", "差价已补齐，等待对庄发货给买家", "待发货给买家", Short.valueOf("12"), "待发货给买家"),
        对庄已退差价等待对庄发货((short) 100, "对庄已退差价", "差价已退，等待对庄发货", "差价已退，等待对庄发货给买家", "待发货给买家", Short.valueOf("12"), "待发货给买家"),
        等待用户收货((short) 105, "等待用户收货", "宝贝已从鉴定担保中心发出，等待买家收货", "宝贝已从鉴定担保中心发出，等待买家收货", "待买家收货", Short.valueOf("13"), "待买家收货"),
        物流已签收((short) 110, "物流已签收", "宝贝已从鉴定担保中心发出，等待买家收货", "宝贝已从鉴定担保中心发出，等待买家收货", "待买家收货", Short.valueOf("13"), "待买家收货"),
        确认留货成功((short) 115, "确认留货成功", "买家已确定收货", "买家已确认收货，交易成功", "已完成", Short.valueOf("15"), "已完成"),
        客服审核取消((short) 120, "客服审核取消", "已取消订单", "", "已取消", Short.valueOf("-2"), "已取消"),
        取消订单((short) -1, "取消订单", "订单已取消", "", "已取消", Short.valueOf("-2"), "已取消");

        private short status;
        private String text;
        private String showText;
        private String showAssistantText;
        private String showBackstageText;
        private Short category;//状态汇总
        private String categoryName;//状态汇总名称

        ProcessStatusEnum(short status, String text, String showText, String showAssistantText, String showBackstageText, Short category, String categoryName) {
            this.status = status;
            this.text = text;
            this.showText = showText;
            this.showAssistantText = showAssistantText;
            this.showBackstageText = showBackstageText;
            this.category = category;
            this.categoryName = categoryName;
        }
    }
}
