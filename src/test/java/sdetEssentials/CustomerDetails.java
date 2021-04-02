package sdetEssentials;

/*POJO Class - Plain Object Java Class which contains getters and setters for
 the variables which we want to get the values from user.
 */

import lombok.Data;
/*
@Data is from lombok library which is EQUIVALENT TO COMBINATION OF @GETTER @SETTER @REQUIREDARGSCONSTRUCTOR @TOSTRING
@EQUALSANDHASHCODE
LOMBOK DATA ANNOTATION (@DATA) GENERATES GETTERS FOR ALL FIELDS,
A USEFUL TOSTRING METHOD, AND HASHCODE AND EQUALS IMPLEMENTATIONS THAT CHECK ALL NON-TRANSIENT FIELDS.
WILL ALSO GENERATE SETTERS FOR ALL NON-FINAL FIELDS, AS WELL AS A CONSTRUCTOR.
A @DATA ANNOTATIONS EQUIVALENT TO COMBINATION OF @GETTER @SETTER @REQUIREDARGSCONSTRUCTOR @TOSTRING @EQUALSANDHASHCODE.
 */
@Data
public class CustomerDetails {
    String bookName;
    String purchaseDate;
    int amount;
    String location;
}
