package com.azure.webapp;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.storage.StorageAccount;
import com.microsoft.rest.LogLevel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AzureCompute {

	public static void main(String[] args) {
		
		//tenant id az account tenant list
		Azure azure = Azure.configure()
			    .withLogLevel(LogLevel.BASIC)
			    .authenticate(new ApplicationTokenCredentials("2ed00027-b826-4a92-9089-4a8c255fb99a", "b3594ec4-c17b-4852-8217-2035b4b0a286", "Tlh8Q~R7AasS8gb291Yq2e2RQrfufjoqT6gkNb8r", AzureEnvironment.AZURE))
			    .withSubscription("d57b17c6-c6ae-4051-919f-6f86ca9b0684");

		
			VirtualMachine vm = azure.virtualMachines().getById("/subscriptions/d57b17c6-c6ae-4051-919f-6f86ca9b0684/resourceGroups/virtual-machine-rg/providers/Microsoft.Compute/virtualMachines/vmcodechallenge2");
			ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("value is :::"+mapper.writeValueAsString(vm));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub

	}

}
