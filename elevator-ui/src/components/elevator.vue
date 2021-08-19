<template>
  <div class="box">
    <el-table :data="elevatorList" stripe style="width: 100%">
      <el-table-column prop="elevatorId" label="电梯编号"> </el-table-column>
      <el-table-column prop="elevatorName" label="电梯名称"> </el-table-column>
      <el-table-column label="操作" v-if="power">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleElevatorEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleElevatorDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-button type="primary" @click="addElevator" v-if="power">添加电梯</el-button>

    <el-dialog :title="title" :visible.sync="isElevatorAdd">
      <el-form :model="ElevatorForm">
        <el-form-item label="电梯名称">
          <el-input
            v-model="ElevatorForm.elevatorName"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelElevator">取 消</el-button>
        <el-button type="primary" @click="addElevatorSend">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      elevatorList: [],
      isElevatorAdd: false,
      title: "添加电梯",
      ElevatorForm: {},
      power: false
    };
  },
  methods: {
    getList() {
      this.$axios.get("/elevator/getAll").then((success) => {
        this.elevatorList = success.data;
      });
    },
    handleElevatorEdit(a, b) {
      console.log(b);
      this.title = "编辑电梯";
      this.isElevatorAdd = true;
      this.ElevatorForm = b;
    },
    handleElevatorDelete(a, b) {
      this.$axios.get(`/elevator/del/${b.elevatorId}`).then((success) => {
        this.getList();
      });
    },
    cancelElevator() {
      this.isElevatorAdd = false;
      if (this.title == "编辑电梯") {
        this.title = "添加电梯";
      }
      this.ElevatorForm = {};
    },
    addElevator() {
      this.isElevatorAdd = true;
    },
    addElevatorSend() {
      this.isElevatorAdd = false;

      console.log(this.ElevatorForm);
      if (this.title == "添加电梯") {
        this.$axios
          .get(`/elevator/add/${this.ElevatorForm.elevatorName}`)
          .then((success) => {
            console.log(success);
            this.getList();
            this.ElevatorForm = {};
          });
      } else {
        this.$axios
          .get(
            `/elevator/edit/${this.ElevatorForm.elevatorId}/${this.ElevatorForm.elevatorName}`
          )
          .then((success) => {
            this.getList();
          });
      }
    },
  },
  created() {
    this.getList();

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