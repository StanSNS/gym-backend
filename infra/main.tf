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

resource "azurerm_resource_group" "rgbs" {
  name     = "RG-BS"
  location = "North Europe"
}
