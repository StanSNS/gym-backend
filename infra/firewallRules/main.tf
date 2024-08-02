terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.113"
    }
  }
}

provider "azurerm" {
  features {}
}

data "azurerm_windows_web_app" "web_app" {
  name                = "gymfitbulgaria-api"
  resource_group_name = "RG-BS"
}

data "azurerm_postgresql_flexible_server" "pgsql_server" {
  name                = "apfs-bssns99"
  resource_group_name = "RG-PGSQLFS"
}

locals {
  outbound_ips = split(",", data.azurerm_windows_web_app.web_app.outbound_ip_addresses)
}

resource "azurerm_postgresql_flexible_server_firewall_rule" "firewall_rules" {
  count = length(local.outbound_ips)

  name             = "fw-rule-${count.index}"
  server_id        = data.azurerm_postgresql_flexible_server.pgsql_server.id
  start_ip_address = local.outbound_ips[count.index]
  end_ip_address   = local.outbound_ips[count.index]
}
