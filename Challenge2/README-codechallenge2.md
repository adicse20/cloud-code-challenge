# cloud-code-challenge2
This repository is created to solve all the code challenges
Code Challenge 2-

We need to write code that will query the meta data of an instance within AWS or Azure or GCP
and provide a json formatted output.
The choice of language and implementation is up to you.
Bonus Points
The code allows for a particular data key to be retrieved individually

First we will create the Azure VM 

![image](https://user-images.githubusercontent.com/37592761/208660304-ccf067a5-a4de-42d0-8f68-32dfda7c4c16.png)

![image](https://user-images.githubusercontent.com/37592761/208660717-b96ea56a-da8f-4f43-89df-a086418bd1ae.png)

GIT Hub Code checking in the branch


![image](https://user-images.githubusercontent.com/37592761/208661777-bcf5a337-4acd-4262-87c3-5149b3a63afb.png)

![image](https://user-images.githubusercontent.com/37592761/208661816-3a5e5b93-21a8-4272-82b2-c66fbdf3ae19.png)

![image](https://user-images.githubusercontent.com/37592761/208661851-ddfdd4a1-ef70-44dc-9a3b-f6e7e78e6397.png)

![image](https://user-images.githubusercontent.com/37592761/208661883-e29b4034-189e-47e5-ab5f-050e156bd6b3.png)

![image](https://user-images.githubusercontent.com/37592761/208661902-84611f79-9a04-4a74-af63-7a665e76e25a.png)

![image](https://user-images.githubusercontent.com/37592761/208661929-e7dfcf4f-4b17-426e-9299-02ac66ad53b4.png)

After creating the Vm we will create the service prinicipal to access the java code 

az ad sp create-for-rbac --name AzureJavaCodeChallenge --role Contributor --scopes /subscriptions/<subscriptionId>

After creating the service prinicipal we will create the Client Id,Client Secret and put in Azure constructor


We can also check in the powershell by the command 

Invoke-RestMethod -Headers @{"Metadata"="true"} -Method GET -NoProxy -Uri "http://169.254.169.254/metadata/instance?api-version=2021-02-01" | ConvertTo-Json -Depth 64









