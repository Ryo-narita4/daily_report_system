package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Business;

public class BusinessValidator {
    public static List<String> validate(Business b){
        List<String> errors = new ArrayList<String>();

        String company_name_error = _validateCompanyName(b.getCompany_name());
        if(!company_name_error.equals("")){
            errors.add(company_name_error);
        }

        String title_error = _validateTitle(b.getTitle());
        if(!title_error.equals("")){
            errors.add(title_error);
        }

        String content_error = _validateContent(b.getContent());
        if(!content_error.equals("")){
            errors.add(content_error);
        }

        return errors;
    }

    private static String _validateCompanyName(String company_name){
        if(company_name == null || company_name.equals("")){
            return "企業名を入力してください。";
        }
        return "";
    }

    private static String _validateTitle(String title){
        if(title == null || title.equals("")){
            return "タイトルを入力してください。";
        }
        return "";
    }

    private static String _validateContent(String content){
        if(content == null || content.equals("")){
            return "内容を入力してください。";
        }
        return "";
    }


}
