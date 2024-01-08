<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    status-icon
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
  >
    <el-form-item label="Username" prop="username">
      <el-input v-model="ruleForm.username" type="text" autocomplete="off" />
    </el-form-item>
    <el-form-item label="Password" prop="password">
      <el-input
        v-model="ruleForm.password"
        type="password"
        autocomplete="off"
      />
    </el-form-item>
  
    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)"
        >Submit</el-button
      >
      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
    </el-form-item>
  </el-form>
</template>



<script lang="ts">
import { reactive, ref } from 'vue'
import { ElMessage, type FormInstance, type FormRules } from 'element-plus'
import { getInfo,getUserInfo } from '@/api/user'

export default {
  name: "Login",
  setup(){
      const ruleFormRef = ref<FormInstance>()
      const validatePass = (rule: any, value: any, callback: any) => {
        if (value === '') {
          callback(new Error('Please input the username'))
        } else if(value.length<5){
          callback("the length of username canoot less than 5")
        } else{
          callback()
        }
      }
      const validatePass2 = (rule: any, value: any, callback: any) => {
        if (value === '') {
          callback(new Error('Please input the password'))
        }
        else {
          callback()
        }
      }

      const ruleForm = reactive({
        username: '',
        password: '',
      })

      const rules = reactive<FormRules<typeof ruleForm>>({
        username: [{ validator: validatePass, trigger: 'blur' }],
        password: [{ validator: validatePass2, trigger: 'blur' }],
      })



      const resetForm = (formEl: FormInstance | undefined) => {
        if (!formEl) return
        formEl.resetFields()
      }

      return{
        ruleForm,
        resetForm,
        ruleFormRef,
        rules
      }
  },
  data(){
      return{
        
      }
  },
    methods:{
      dologin(){
        this.$store.dispatch("LOGIN",this.ruleForm).then((res: any) =>{
          if(res.status == 200){
            getInfo()
            this.$router.push({name: 'foodManager'})
            ElMessage('welcome to XXX '+res.data.user.username)
            setTimeout(() => {
              getUserInfo(1);
            },2000)
          }
        })        
      },
      submitForm(formEl: FormInstance | undefined) {
        if (!formEl) return
        formEl.validate((valid) => {
          if (valid) {
            console.log('submit!')
            this.dologin()
          } else {
            console.log('error submit!')
            return false
          }
        })
      }
    }
};
</script>

<style scoped>

</style>

