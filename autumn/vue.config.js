const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/seed': {
        target: 'http://localhost:8088',
        pathRewrite:{'^/seed':''},
        ws: true,
        changeOrigin: true
      },
    }
  },
  lintOnSave: false,
})
