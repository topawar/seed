<template>
  <div class="index">
    <div class="registerInput">
      <el-input v-model="user.name" placeholder="请输入用户名"></el-input>
      <el-input v-model="user.password" placeholder="请输入密码"></el-input>
      <el-button type="info" @click="login" class="submitRegister">获取用户信息</el-button>
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Register',
  data(){
    return {
      user:{name:'',password:''}
    }
  },
  methods:{
    // getUser(){
    //   console.log(this)
    //   axios.get('http://localhost:8080/seed/selectAll').then(
    //       response =>{
    //         console.log('请求成功了',response.data)
    //       },
    //       error => {
    //         console.log('请求失败了',error.message)
    //       }
    //   )
    // }
    login(){
      const onceUser = this.$qs.stringify({name:this.user.name,passWord:this.user.password});
      this.$axios({
        method:'post',
        url:'http://localhost:8080/seed/login',
        data: onceUser
      }).then(
          response =>{
            if (response.data){
              this.$router.push('/index')
            }else{
              alert('用户名或密码错误')
            }
          }
      )
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  div .registerInput{
    width: 300px;
    position: absolute;
    top: 40%;
    left: 60%;
    margin-left: -200px;
    margin-top: -100px;
  }
  .submitRegister{
    margin-top: 20px;
  }
</style>
