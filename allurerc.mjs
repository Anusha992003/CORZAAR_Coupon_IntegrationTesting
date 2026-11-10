import { defineConfig } from "allure";
 
export default defineConfig({
name: "Corzaar Coupon Integration Report",
output: "./allure-report",
 
plugins: {
awesome: {
options: {
singleFile: true,
reportLanguage: "en"
}
}
}
});