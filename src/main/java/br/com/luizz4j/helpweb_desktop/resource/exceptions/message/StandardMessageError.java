package br.com.luizz4j.helpweb_desktop.resource.exceptions.message;

public abstract class StandardMessageError {

   public static final String INVALID_EMAIL = "Informe um E-mail valido";
   public static final String INVALID_EMAIL_NOTBLANK = "O E-mail é obrigatorio";
   public static final String INVALID_EMAIL_REGISTER = "O E-mail informado já foi registrado";

   public static final String INVALID_CPF = "Informe um CPF valido";
   public static final String INVALID_CPF_NOTBLANK = "O CPF é obrigatorio";
   public static final String INVALID_CPF_REGISTER = "O CPF informado já foi registrado";

   public static final String PASSWORD_DOES_NOT_MATCH = "A senha informada não corresponde a ultima senha";

   public static final String INVALID_TICKET_NOTBLANK = "Descreva em poucas palavras o problema";
   public static final String INVALID_TICKET_NOTNULL = "Esse campo deve ser preenchido";

   public static final String INVALID_DESCRIPTION_NOTBLANK = "Informe uma breve descrição do problema";
   public static final String INVALID_DESCRIPTION_NOTNULL = "Esse campo deve ser preenchido";
   public static final String TICKET_NOT_FOUND = "O ticket não foi encontrado na nossa base de dados";
   public static final String TICKET_IN_STATUS_OPEN = "O ticket não pode ser fechado sem que esteja em andamento";



}
