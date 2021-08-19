<template>
  <div class="main">
    <el-table :data="userList" stripe style="width: 100%">
      <el-table-column prop="userId" label="用户ID" width="180">
      </el-table-column>
      <el-table-column prop="userName" label="用户名称" width="180">
      </el-table-column>
      <el-table-column prop="userPowerStr" label="用户权限"></el-table-column>
      <el-table-column label="操作" v-if="power">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleUserEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleUserDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div class="footer">
      <el-button type="primary" @click="addUserShow" v-if="power">添加用户</el-button>
    </div>
    <el-dialog :title="title" :visible.sync="isUserAdd">
      <el-form :model="userForm">
        <el-form-item label="用户名称">
          <el-input v-model="userForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" v-if="title == '添加用户'">
          <el-input v-model="userForm.userPwd" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户权限">
          <el-select v-model="userForm.userPower" placeholder="请选择用户权限">
            <el-option label="可读可写" value="0"></el-option>
            <el-option label="只读" value="1"></el-option>
            <el-option label="无权限" value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelUser">取 消</el-button>
        <el-button type="primary" @click="addUser">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userList: [],
      userForm: {},
      isUserAdd: false,
      title: "编辑用户",
      power: false
    };
  },
  methods: {
    getUser() {
      this.$axios.get("/user/getAll").then((success) => {
        this.userList = success.data;
        console.log(success.data);

        success.data.forEach((vlaue) => {
          if (vlaue.userPower == 0) {
            vlaue.userPowerStr = "可读可写";
          } else if (vlaue.userPower == 1) {
            vlaue.userPowerStr = "只读";
          } else {
            vlaue.userPowerStr = "无权限";
          }
        });
      });
    },
    handleUserEdit(a, b) {
      this.title = "编辑用户";
      this.userForm = b;
      this.isUserAdd = true;
    },
    handleUserDelete(a, b) {
      this.$axios.delete(`/user/${b.userId}`).then((success) => {
        console.log(success);
        this.getUser();
      });
    },
    addUser() {
      this.isUserAdd = false;

      if (this.title === "编辑用户") {
        this.$axios.put("/user/update", this.userForm).then((success) => {
          this.getUser();
        });
      } else {
        this.$axios.post("/user/add", this.userForm).then((success) => {
          this.getUser();
        });
      }
    },
    addUserShow() {
      this.isUserAdd = true;
      this.title = "添加用户";
    },
    cancelUser() {
      this.isUserAdd = false;
      this.userForm = {};
    },
  },
  created() {
    this.getUser();

    this.$axios.get("/user/getPower").then((success) => {
      if (success.data == "fail") {
      } else {
        this.power = true;
      }
    });
  },
};
</script>

<style>
.el-main {
  line-height: 0;
}
</style>