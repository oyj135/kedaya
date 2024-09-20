const { generateService } = require("@umijs/openapi");

generateService({
  requestLibPath: "import request from '@request",
  schemaPath: "https://localhost:8080/api/v2/api-docs",
  serversPath: "./src",
});