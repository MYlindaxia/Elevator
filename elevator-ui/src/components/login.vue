<template>
  <div id="box">
    <h3>电梯维修后台登陆界面</h3>
    <section id="login">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width="40px"
        class="demo-ruleForm"
      >
        <el-form-item label="账号" prop="username">
          <el-input
            type="text"
            v-model="ruleForm.username"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >登录</el-button
          >
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </section>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        username: "",
        password: "",
      },
      rules: {
        
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$axios.post("user/login",{userName:this.ruleForm.username,userPwd:this.ruleForm.password}).
      then(success => {
        
        if(success.data.token != null) {
          window.sessionStorage.setItem("token",success.data.token);
          window.sessionStorage.setItem("username",this.ruleForm.username);
          this.$router.push("/main");

        }else {
          alert("账号或密码输入错误");
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style>
#box{
  text-align: center;
  margin-left: -10em;
  margin-top: -9.5em;
  width: 20em;
  position: absolute;
  left: 50%;
  top: 50%;

}
</style>