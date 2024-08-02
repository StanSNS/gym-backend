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

//PGSQL16 DB
resource "azurerm_resource_group" "argpgsql" {
  name     = "RG-PGSQLFS"
  location = "North Europe"
}

resource "azurerm_postgresql_flexible_server" "apfspgsql" {
  name                          = "apfs-bssns99"
  resource_group_name           = azurerm_resource_group.argpgsql.name
  location                      = azurerm_resource_group.argpgsql.location
  version                       = "16"
  public_network_access_enabled = true
  administrator_login           = "psqladmin"
  administrator_password        = "H@Sh1CoR3!"
  zone                          = "1"

  storage_mb   = 32768
  storage_tier = "P4"

  sku_name = "B_Standard_B1ms"
}

resource "azurerm_postgresql_flexible_server_database" "apfsdpgsql" {
  name      = "gymfitdb"
  server_id = azurerm_postgresql_flexible_server.apfspgsql.id
  collation = "en_US.utf8"
  charset   = "UTF8"
}

resource "azurerm_postgresql_flexible_server_configuration" "apfscpgsql" {
  name      = "require_secure_transport"
  server_id = azurerm_postgresql_flexible_server.apfspgsql.id
  value     = "off"
}

//BACKEND SERVER
resource "azurerm_resource_group" "rgbs" {
  name     = "RG-BS"
  location = "North Europe"
}

resource "azurerm_service_plan" "aspbs" {
  name                = "ASP-BS"
  resource_group_name = azurerm_resource_group.rgbs.name
  location            = azurerm_resource_group.rgbs.location
  os_type             = "Windows"
  sku_name            = "F1"
}

resource "azurerm_windows_web_app" "awwabs" {
  name                = "gymfitbulgaria-api"
  resource_group_name = azurerm_resource_group.rgbs.name
  location            = azurerm_service_plan.aspbs.location
  service_plan_id     = azurerm_service_plan.aspbs.id


  site_config {
    application_stack {
      current_stack                = "java"
      java_version                 = "17"
      java_embedded_server_enabled = true
    }
    always_on = false
  }

  app_settings = {
    DB_HOST     = azurerm_postgresql_flexible_server.apfspgsql.fqdn
    DB_PORT     = "5432"
    DB_NAME     = azurerm_postgresql_flexible_server_database.apfsdpgsql.name
    DB_USERNAME = azurerm_postgresql_flexible_server.apfspgsql.administrator_login
    DB_PASSWORD = azurerm_postgresql_flexible_server.apfspgsql.administrator_password

    USER_FRONTEND_BASE_URL         = "https://gymfitbulgaria.azurewebsites.net/"
    ADMIN_FRONTEND_BASE_URL        = "*"
    SILA_BG_API_KEY                = "Y1nVBIx7QV7aSlHyf1xHXdEmr3G4b64U3b1PCpFR0CfXUGRa64SFPYpD05MsGiflgaoH61CkqkplIZAy"
    SILA_BG_AUTH_EMAIL             = "stanimirsergev159@gmail.com"
    SILA_BG_AUTH_PASSWORD          = "bymejuh"
    EMAIL_HOST                     = "smtp.gmail.com"
    EMAIL_PORT                     = 587
    EMAIL_ORIGIN                   = "gymfitbulgaria@gmail.com"
    EMAIL_PASSWORD                 = "iefn yzqo tpej keuy"
    EMAIL_PROPS_KEY_ONE            = "mail.smtp.starttls.enable"
    EMAIL_PROPS_VALUE_ONE          = "true"
    EMAIL_PROPS_KEY_TWO            = "mail.smtp.auth"
    EMAIL_PROPS_VALUE_TWO          = "true"
    EMAIL_PROPS_KEY_THREE          = "mail.smtp.ssl.trust"
    EMAIL_PROPS_VALUE_THREE        = "smtp.gmail.com"
    ADMIN_AUTH_LOGIN_USERNAME      = "admin"
    ADMIN_AUTH_LOGIN_PASSWORD      = "admin"
    APP_JWT_EXPIRATION_MILISECONDS = 86400000
    APP_JWT_SECRECT                = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb"
    SPEEDY_API_USERNAME            = "1995900"
    SPEEDY_API_PASSWORD            = "6625235775"
  }
}
