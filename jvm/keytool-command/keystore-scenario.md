# keytool - manages keystores and certificates

# generate keystore
> keytool -genkey -alias tomcat -keyalg RSA

    secret
    secret
    cosmin bucur
    it
    cdb pfa
    bucharest
    bucharest
    ro
    y

tomcat password: 
secret
secret

go to C:\Users\cosmin.bucur\.keystore to see your new keystore

warning
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore C:\Users\cosmin.bucur\.keystore -destkeystore C:\Users\cosmin.bucur\.keystore -deststoretype pkcs12"

# convert .keystore to pkcs12
> keytool -importkeystore -srckeystore "C:\Users\cosmin.bucur\.keystore" -destkeystore "C:\Users\cosmin.bucur\.keystore" -deststoretype pkcs12

# see keystore content
> keytool -list -v -keystore "C:\Users\cosmin.bucur\.keystore" -storetype pkcs12
