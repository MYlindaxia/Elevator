<template>
  <el-container>
    <el-header>{{ username }},欢迎来到电梯管理系统</el-header>
    <el-container>
      <el-aside width="150px">
        <el-row class="tac">

          <el-col :span="12">
            <el-menu
              class="el-menu-vertical-demo"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
              @select="openMenu"
            >
              <el-menu-item :index="index.toString()" v-for="(item,index) in asideList" :key="index">
                <i class="el-icon-menu"></i>
                <span slot="title">{{item.menuName}}</span>
              </el-menu-item>
              <el-menu-item index="-1">
                <i class="el-icon-menu"></i>
                <span slot="title">注销登录</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>{{showH1()}}<router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      asideList: []
    };
  },
  computed: {
    username() {
      return window.sessionStorage.getItem("username");
    },
  },
  methods: {
    openMenu(value) {
      if(value == 0) {
        this.$router.push("/main/order");
      }else if(value == 1) {
        this.$router.push("/main/user");
      }else if(value == -1) {
        window.sessionStorage.clear();
        this.$router.push("/");
      }else if(value == 2) {
        this.$router.push("/main/elevator")
      }
    },
        showH1() {
      if(window.location.pathname.toString().replace("/","").replace("/","") == "main") {
        return "欢迎来到电梯管理系统";
      }
    }
  },
  created() {
    this.$axios.get("menu/getMenuByToken").then((success) => {
      this.asideList = success.data;
    });
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
body {
  height: 100vh;
}
#app {
  height: 100%;
}

.el-container {
  height: 100%;
}

.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.el-col-12 {
  width: 100%;
  height: 100%;
}

.el-row {
  height: 100%;
}

.el-menu {
  height: 100%;
}

</style>