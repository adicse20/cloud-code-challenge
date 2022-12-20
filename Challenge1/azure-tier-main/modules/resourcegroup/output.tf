output "resource_group_name" {
    value = azurerm_resource_group.azure-tier-rs.name
    description = "Name of the resource group."
}

output "location_id" {
    value = azurerm_resource_group.azure-tier-rs.location
    description = "Location id of the resource group"
}
