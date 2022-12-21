# Terraform Infrastructure code to deploy three-tier architecture on azure

#Problem Statement

1. Here in this we are creating one One virtual network name  virtualnet01 which is connected to 3 subnet.
2. Each subnet will have one virtual machine.
3. First virtual machine -> allow inbound traffic from internet only.
4. Second virtual machine -> entertain traffic from first virtual machine only and can reply the same virtual machine again.
5. App can connect to database and database can connect to app but database cannot connect to web.



## Solution

### The Terraform resources will consists of following structure


main.tf                 
vars.tf                 
output.tf               
terraform.tfvars        


#Module

A module is a container for multiple resources that are used together.
We are giving resource specific details in the module folder only


For the solution, we have created and used five modules:
1. resourcegroup - creating resourcegroup
2. networking - creating azure virtual network and required subnets
3. securitygroup - creating network security group.
4. compute - creating availability sets, network interfaces and virtual machines
5. database - creating database server and database

All the tier are placed in the modules folder and the variable are stored under **terraform.tfvars**

To run the code we need to append the variables in the terraform.tfvars

Each module consists of atleast two files: main.tf, vars.tf

resourcegroup and networking modules consists of one extra file named output.tf

## Deployment

### Steps

terraform init`
terraform plan
terraform validate
terraform apply


