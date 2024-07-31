# Micro-serviço com Spring + Oracle Cloud
O objetivo deste projeto foi exemplificar como realizar a criação de um microserviço completo usando Spring Boot, integrando com serviços do modo gratuito da Oracle Cloud para armazenamento de objetos, arquivos e disparo de e-mails. A ideia é simular um microserviço capaz de gerar e enviar relatórios por e-mail, utilizando os serviços Object Storage e Mail Delivery.

## Modo Gratuito Oracle Cloud

Se quiser criar uma conta gratuita na Oracle Cloud, acesse o link [Oracle Cloud Free Tier](https://social.ora.cl/60049HoAk) e siga as instruções. 

A conta gratuita oferece serviços com uso ilimitado como Instâncias de Máquinas Virtuais, Object Storage, Email Delivery, Banco de Dados NoSQl e Banco de Dados SQL.

## Pré-requisitos para execução
* [Possuir conta na Oracle Cloud](https://social.ora.cl/60049HoAk)
* Java Versão 21
* Maven 3.9.7

## Configuração

### Application.properties

O arquivo de configuração `application.properties` deve ser configurado com as informações da sua conta Oracle Cloud. Para isso, você deve preencher o arquivo `application.properties` na pasta `src/main/resources` com as seguinte informações:

```properties
# Oracle Cloud  
spring.application.name=mailservice
spring.mail.username=YOUR_STMP_USERNAME
spring.mail.password=YOUR_SMTP_PASSWORD
spring.mail.from=YOUR_REGISTERED_EMAIL
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.email.sa-saopaulo-1.oci.oraclecloud.com
spring.mail.host=smtp.email.sa-saopaulo-1.oci.oraclecloud.com
spring.mail.port=587
spring.mail.protocol=smtp
```

### Configuração Credenciais SDK

No arquivo `.oci/config` você deve configurar as credenciais de acesso á Oracle Cloud. Para isso, você deve preencher o arquivo `.oci/config` na pasta raiz do projeto com as configs geradas na sua conta. 

**Passo a passo**

1.	Acesse a sua conta Oracle Cloud.
2. Vá para a página de detalhes do seu perfil no console OCI. Vá para a aba “Chaves de API”. Clique no botão “Adicionar chave de API”. Isso abrirá a seguinte janela pop-up.
3.	Insira um nome para a chave de API e clique no botão “Adicionar”. Isso fará o download do arquivo da chave de API.
4.	Copie o conteúdo do arquivo e cole-o no arquivo ~/.oci/config em sua máquina local.

```properties
[DEFAULT]
user=YOUR_USER_ID
fingerprint=FINGERPRINT
tenancy=TENANCY_ID
region=sa-saopaulo-1
key_file=private-key.pem
```