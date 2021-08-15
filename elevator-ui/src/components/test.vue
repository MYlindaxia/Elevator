<template>
  <el-form :model="environmentForm" ref="environmentForm">
    <el-row
      :gutter="24"
      v-for="(item, index) in environmentForm.items"
      :key="item.key"
    >
      <el-col :span="6">
        <el-form-item
          :prop="'items.' + index + '.name'"
          :rules="{ required: true, message: '名称不能为空', trigger: 'blur' }"
        >
          <el-input v-model="item.name"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item
          :prop="'items.' + index + '.variable'"
          :rules="{
            required: true,
            message: '变量值不能为空',
            trigger: 'blur',
          }"
        >
          <el-input v-model="item.variable"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item
          :prop="'items.' + index + '.description'"
          :rules="{ required: true, message: '描述不能为空', trigger: 'blur' }"
        >
          <el-input
            type="textarea"
            :rows="1"
            v-model="item.description"
          ></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="3" v-if="environmentForm.items.length !== 1">
        <i
          @click="removeEnvironmentForm(item)"
          style="font-size: 28px; cursor: pointer"
          class="el-icon-delete"
        ></i>
      </el-col>
      <el-col :span="3">
        <el-button
          @click="addEnvironmentForm"
          size="mini"
          class="el-icon-plus"
        ></el-button>
      </el-col>
    </el-row>

    <el-form-item>
      <el-button type="primary" @click="submitForm('environmentForm')"
        >提交</el-button
      >
      <el-button @click="resetForm('environmentForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      environmentForm: {
        items: [
          {
            name: "",
            variable: "",
            description: "",
          },
        ],
      },
    };
  },
  methods: {
    //提交事件
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log("提交", this.environmentForm);
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    //重置事件
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //移除表单项事件
    removeEnvironmentForm(item) {
      var index = this.environmentForm.items.indexOf(item);
      if (index !== -1) {
        this.environmentForm.items.splice(index, 1);
      }
    },
    //添加表单项事件
    addEnvironmentForm() {
      this.environmentForm.items.push({
        name: "",
        variable: "",
        description: "",
        key: Date.now(),
      });
    },
  },
};
</script>

<style>
</style>