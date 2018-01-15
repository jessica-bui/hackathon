*** Generate encrypted password ***
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input=password password=my_secret_key algorithm=PBEWithMD5AndDES
