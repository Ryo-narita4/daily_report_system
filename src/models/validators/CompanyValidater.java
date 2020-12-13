package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Company;

public class CompanyValidater {
    public static List<String> validate(Company c){
        List<String> errors = new ArrayList<String>();

        String name_error = _validateCompanyName(c.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String address_error = _validateCompanyAddress(c.getAddress());
        if(!address_error.equals("")){
            errors.add(address_error);
        }

        String tell_error = _validateCompanyTell(c.getTell());
        if(!tell_error.equals("")){
            errors.add(tell_error);
        }
/*
        String mail_error = _validateCompanyMail(c.getMail());
        if(!mail_error.equals("")){
            errors.add(mail_error);
        }
*/

        String charge_error = _validateCompanyCharge(c.getCharge());
        if(!charge_error.equals("")){
            errors.add(charge_error);
        }

        return errors;
    }
//各種入力チェックメソッド
    private static String _validateCompanyName(String name){
        if(name == null || name.equals("")){
            return "企業名を入力してください。";
        }
        return "";
    }

    private static String _validateCompanyAddress(String address){
        if(address == null || address.equals("")){
            return "住所を入力してください。";
        }
        return "";
    }

    private static String _validateCompanyTell(String tell){
        if(tell == null || tell.equals("")){
            return "電話番号を入力してください。";
        }
        return "";
    }
/*
    private static String _validateCompanyMail(String mail){
        if(mail == null || mail.equals("")){
            return "メールアドレスを入力してください。";
        }
        return "";
    }
*/
    private static String _validateCompanyCharge(String charge){
        if(charge == null || charge.equals("")){
            return "担当者または代表者を入力してください。";
        }
        return "";
    }



}


