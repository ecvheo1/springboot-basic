package org.prgrms.kdt.command.io;

import java.text.MessageFormat;

public class Output {
    private Output() {
    }

    public static void commandChooseMessage() {
        System.out.println("=== Voucher Program ===");
        System.out.println("Type 'exit' for Exit.");
        System.out.println("Type 'customer' for customer menu");
        System.out.println("Type 'voucher' for voucher menu");
    }

    public static void customerServiceMessage() {
        System.out.println("=== Customer ===");
        System.out.println("Type 'back' for going back.");
        System.out.println("Type 'create' to create new customer");
        System.out.println("Type 'list' to list all customers");
        System.out.println("Type 'my_voucher_list' to list all vouchers of specific customer");
        System.out.println("Type 'blacklist' to list all blacklists");
    }

    public static void voucherServiceMessage() {
        System.out.println("=== Voucher ===");
        System.out.println("Type 'back' for going back.");
        System.out.println("Type 'create' to create new voucher");
        System.out.println("Type 'list' to list all vouchers");
        System.out.println("Type 'find_customer' to find specific customers of voucher_id");
    }

    public static void voucherDeleteMessage() {
        System.out.println("=== Voucher Delete ===");
        System.out.println("Type 'back' for going back.");
        System.out.println("Type 'delete' to delete specific voucher");
    }

    public static void inputTypeErrorMessage(final String commandInput) {
        System.out.println("=== Input type error ===");
        System.out.println(MessageFormat.format("{0}은(는) 지원하지 않는 명령어입니다.", commandInput));
    }

    public static void voucherChooseMessage() {
        System.out.println("=== Voucher Create ===");
        System.out.println("Choose the type of voucher.");
        System.out.println("- FixedAmountVoucher");
        System.out.println("- PercentDiscountVoucher");
    }

    public static void howMuchDiscountMessage(final String voucherType) {
        if (voucherType.equals("FixedAmountVoucher")) {
            System.out.println("할인 가격을 얼마로 설정하시겠습니까?");
        } else if (voucherType.equals("PercentDiscountVoucher")) {
            System.out.println("할인율을 몇 퍼센트로 설정하시겠습니까?");
        } else {
            wrongVoucherTypeMessage(voucherType);
        }
    }

    public static void wrongVoucherTypeMessage(final String voucherType) {
        System.out.println("=== Input type error ===");
        System.out.println(voucherType + "은(는) 존재하지 않는 voucher type 입니다.");
        System.out.println("'FixedAmountVoucher', 'PercentDiscountVoucher'를 입력하세요.");
    }

    public static void exitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}