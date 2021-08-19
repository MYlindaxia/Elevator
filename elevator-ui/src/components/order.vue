<template>
  <div class="box">
    <el-table :data="orderList" stripe style="width: 100%">
      <el-table-column prop="orderId" label="订单编号" width="80">
      </el-table-column>
      <el-table-column prop="elevatorId" label="电梯编号" width="80">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="180">
      </el-table-column>
      <el-table-column prop="createVillage" label="创建地点" width="100">
      </el-table-column>
      <el-table-column prop="problem" label="问题" width="180">
      </el-table-column>
      <el-table-column prop="resultStr" label="结果" width="80"> </el-table-column>
      <el-table-column prop="resultTime" label="处理时间"> </el-table-column>
      <el-table-column label="操作" v-if="power">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div class="bottom">
      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[10, 20, 30, 40, 50]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
        >
        </el-pagination>
      </div>
      <el-button type="primary" id="add" @click="isAdd = true" v-if="power"
        >添加订单</el-button
      >
    </div>

    <el-dialog :title="boxmsg.title" :visible.sync="isAdd">
      <el-form :model="form">
        <el-form-item label="出错电梯Id" type="number">
          <el-select
            v-model="form.elevatorId"
            placeholder="请选择出错电梯Id"
            type="number"
          >
            <el-option label="1001" value="1001"></el-option>
            <el-option label="1002" value="1002"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="小区名称">
          <el-input v-model="form.createVillage" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电梯问题">
          <el-input v-model="form.problem" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="处理结果" type="number">
          <el-select
            v-model="form.result"
            placeholder="请选择处理结果"
            type="number"
          >
            <el-option label="成功解决" value="0"></el-option>
            <el-option label="暂未处理" value="1"></el-option>
            <el-option label="处理异常" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item v-show="dataChoose">
          <el-date-picker
            type="date"
            placeholder="选择日期"
            v-model="form.date1"
            style="width: 100%"
          ></el-date-picker>
          <el-time-picker
            placeholder="选择时间"
            v-model="form.date2"
            style="width: 100%"
          ></el-time-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="isAdd = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orderList: [],
      isAdd: false,
      form: {
        elevatorId: "",
        createVillage: "",
        problem: "",
        result: "",
        date1: "",
        date2: "",
      },
      currentPage4: 1,
      dataChoose: false,
      total: 0,
      pageSize: 10,
      boxmsg: {
        title: "添加订单",
      },
      power: false
    };
  },
  methods: {
    getList() {
      this.$axios
        .get(`order/getByLimit/${this.currentPage4}/${this.pageSize}`)
        .then((success) => {
          console.log(success.data);
          success.data.forEach((value) => {
            if(value.result == "1") {
              value.resultStr = "暂未处理";
            }else if(value.result == "0") {
              value.resultStr = "成功解决";
            }else {
              value.resultStr = "处理异常";
            }
          })
          this.orderList = success.data;
        });
    },
    getTotal() {
      this.$axios.get("order/getAll").then((success) => {
        this.total = success.data.length;
      });
    },
    handleEdit(a, b) {
      this.boxmsg.title = "编辑订单";
      this.isAdd = true;
      this.form.elevatorId = b.elevatorId;
      this.form.createVillage = b.createVillage;
      this.form.problem = b.problem;
      this.form.result = b.result;
      this.form.createTime = b.createTime;
      this.form.orderId = b.orderId;
    },
    handleDelete(a, b) {
      this.$axios.delete(`/order/delete/${b.orderId}`).then((success) => {
        console.log(success);
        this.getList();
      });
    },
    handleSizeChange(a) {
      this.pageSize = a;
      this.getList();
    },
    handleCurrentChange(a) {
      this.currentPage4 = a;
      this.getList();
    },
    submit() {
      this.isAdd = false;
      this.form.result = parseInt(this.form.result);
      this.form.elevatorId = parseInt(this.form.elevatorId);
      let now = new Date();
      this.form.createTime = `${now.getFullYear()}-${now.getMonth()}-${now.getDate()} ${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
      if (this.form.date1 !== "") {
        this.form.resultTime = `${now.getFullYear(
          this.form.date1
        )}-${now.getMonth(this.form.date1)}-${now.getDate(
          this.form.date1
        )} ${now.getHours(this.form.date2)}:${now.getMinutes(
          this.form.date2
        )}:${now.getSeconds(this.form.date2)}`;
      } else {
        this.form.resultTime = "";
      }
      delete this.form.date1;
      delete this.form.date2;

      if (this.boxmsg.title === "添加订单") {
        this.$axios.post("/order/add", this.form).then((success) => {
          this.getTotal();
          this.getList();
        });
      } else {
        this.boxmsg.title = "添加订单";
        this.$axios.put("/order/update", this.form).then((success) => {
          this.getTotal();
          this.getList();
        });
      }
    },
  },
  watch: {
    form: {
      deep: true,
      handler(newValue, oldValue) {
        if (newValue.result == "0") {
          this.dataChoose = true;
        }
      },
    },
  },
  created() {
    this.getTotal();
    this.getList();
    this.$axios.get("/user/getPower").then((success) => {
      if(success.data == "fail") {
        
      }else {
        this.power = true;
      }
    })
  },
};
</script>

<style>
.el-main {
  line-height: 0;
}
.bottom {
  display: flex;
  justify-content: space-between;
}
.el-form-item {
  display: flex;
  justify-content: center;
}
.el-dialog {
  width: 33%;
}
</style>