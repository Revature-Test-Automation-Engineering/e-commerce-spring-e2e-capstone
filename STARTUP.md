##STARTUP INSTRUCTIONS

#To start the application the following steps must be taken for the SPRING (Back-end) and REACT (Front-end) code. Steps for each set of code are listed separately.

##SPRING CODE
1) Download application (make sure it includes code in "src>main")
2) Open in IDE
3) Go to "main>resources", or create a resources folder under main if not there (right click main > new > directory, name "resources"), and create a file named "application.yaml"
4) Inside application.yaml add or overwrite the mail features with : 
   mail:
  "host: smtp.gmail.com
  port: 587
  username: ohmybobbiness@gmail.com
  password: zjdyhueqqoldczrl
  transport:
    protocol: smtp
  tls: true
  properties:
    mail:
      smtp:
        auth: true
        starttls:
          enable: true
        ssl.trust: smtp.gmail.com"
5) Inside application.yaml under "datasource" do the following: 
  - add the database url after "url:" 
  - add the database username after "username:"
  - add the database password after "password:"
6) Inside the application.yaml under "jpa" do the following:
  - after "database-platform:" add  "org.hibernate.dialect.PostgreSQL94Dialect"
  - after "ddl-auto" add "create" ONLY THE FIRST TIME THE APPLICATION IS RUN! This will setup the database. After that set "ddl-auto" to "update"
7) Inside application.yaml under "jwt" do the following (if no jwt add it in as "jwt:" without it being a subset to any existing lines):
  - make sure there is a line containing "secret:", create if not.
  - open a powershell terminal and type in "New-Guid"
  - add the resulting Guid string after "secret:" in the yaml file
8) Open .gitignore file und "src" and add "*.yaml" as its own line
9) Run the application file from the "ECommerceApplication" class under main>java>com.revature
10) Review step 6 and update ddl-auto for all subsequent runs.
