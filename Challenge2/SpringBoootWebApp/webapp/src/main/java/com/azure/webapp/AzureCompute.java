package com.azure.webapp;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.DiskInstanceView;
import com.microsoft.azure.management.compute.InstanceViewStatus;
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

		
			VirtualMachine vm = azure.virtualMachines().getById("/subscriptions/d57b17c6-c6ae-4051-919f-6f86ca9b0684/resourceGroups/azure-tier/providers/Microsoft.Compute/virtualMachines/web-vm");
			ObjectMapper mapper = new ObjectMapper();
				
			try {
				System.out.println("value is :::"+mapper.writeValueAsString(vm));
				System.out.println("hardwareProfile");
				System.out.println("    vmSize: " + vm.size());
				System.out.println("storageProfile");
				System.out.println("  imageReference");
				System.out.println("    publisher: " + vm.storageProfile().imageReference().publisher());
				System.out.println("    offer: " + vm.storageProfile().imageReference().offer());
				System.out.println("    sku: " + vm.storageProfile().imageReference().sku());
				System.out.println("    version: " + vm.storageProfile().imageReference().version());
				System.out.println("  osDisk");
				System.out.println("    osType: " + vm.storageProfile().osDisk().osType());
				System.out.println("    name: " + vm.storageProfile().osDisk().name());
				System.out.println("    createOption: " + vm.storageProfile().osDisk().createOption());
				System.out.println("    caching: " + vm.storageProfile().osDisk().caching());
				System.out.println("osProfile");
				System.out.println("    computerName: " + vm.osProfile().computerName());
				System.out.println("    adminUserName: " + vm.osProfile().adminUsername());
				System.out.println("networkProfile");
				System.out.println("    networkInterface: " + vm.primaryNetworkInterfaceId());
				System.out.println("vmAgent");
				System.out.println("  vmAgentVersion: " + vm.instanceView().vmAgent().vmAgentVersion());
				System.out.println("    statuses");
				for (InstanceViewStatus status : vm.instanceView().vmAgent().statuses()) {
				    System.out.println("    code: " + status.code());
				    System.out.println("    displayStatus: " + status.displayStatus());
				    System.out.println("    message: " + status.message());
				    System.out.println("    time: " + status.time());
				}
				System.out.println("disks");
				for (DiskInstanceView disk : vm.instanceView().disks()) {
				    System.out.println("  name: " + disk.name());
				    System.out.println("  statuses");
				    for (InstanceViewStatus status : disk.statuses()) {
				        System.out.println("    code: " + status.code());
				        System.out.println("    displayStatus: " + status.displayStatus());
				        System.out.println("    time: " + status.time());
				    }
				}
				System.out.println("VM general status");
				System.out.println("  provisioningStatus: " + vm.provisioningState());
				System.out.println("  id: " + vm.id());
				System.out.println("  name: " + vm.name());
				System.out.println("  type: " + vm.type());
				System.out.println("VM instance status");
				for (InstanceViewStatus status : vm.instanceView().statuses()) {
				    System.out.println("  code: " + status.code());
				    System.out.println("  displayStatus: " + status.displayStatus());
				}
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub

	}

}
