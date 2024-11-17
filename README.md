## Spring Boot Application EKS Deployment

1. Create container registry in ECR (Elastic Container Registry)

2. Create IAM User, assign AdministratorAccess Policy and Create Access Keys for that user

3. Configure AWS CLI (Replace Key ID and Secret with the one generated for IAM User created above)

```bash
>aws configure

AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Default region name [None]: us-east-1
Default output format [None]: json
```

```bash
>aws configure list

      Name                    Value             Type    Location
      ----                    -----             ----    --------
   profile                <not set>             None    None
access_key     ****************MPLE shared-credentials-file
secret_key     ****************EKEY shared-credentials-file
    region                us-east-1      config-file    ~/.aws/config
```

Credentials and config cann also be manually updated by editing 'config' and 'credentials' file in .aws folder


4. Create cluster :

```bash
>eksctl create cluster - name rvp-np-cluster \
 - region us-east-1 \
 - node-type t3.micro \
 - nodes-min 2 \
 - nodes-max 2
```
