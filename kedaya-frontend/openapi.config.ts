const { generateService } = require("@umijs/openapi");

generateService({
  schemaPath: "https://localhost:8101/api/v2/api-docs",
  serversPath: "./src",
});
