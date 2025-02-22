<template>
  <div id="addAppPage">
    <h2 style="margin-bottom: 32px">创建应用</h2>
    <a-form
      :model="form"
      :style="{ width: '480px' }"
      auto-label-width
      label-align="left"
      @submit="handleSubmit"
    >
      <a-form-item field="appName" label="应用名称">
        <a-input v-model="form.appName" placeholder="请输入应用名称" />
      </a-form-item>
      <a-form-item field="appDesc" label="应用描述">
        <a-input v-model="form.appDesc" placeholder="请输入应用描述" />
      </a-form-item>
      <a-form-item field="appIcon" label="应用图标">
        <a-input v-model="form.appIcon" placeholder="请输入应用图标" />
      </a-form-item>
      <a-form-item field="appIcon" label="应用图标">
        <pictureUploader
          biz="app_icon"
          :value="form.appIcon"
          :onChange="(url) => (form.appIcon = url)"
        />
      </a-form-item>
      <a-form-item field="appType" label="应用类型">
        <a-select
          v-model="form.appType"
          :style="{ width: '320px' }"
          placeholder="请选择应用类型"
        >
          <a-option
            v-for="(value, key) of APP_TYPE_MAP"
            :key="key"
            :label="value"
            :value="Number(key)"
          />
        </a-select>
      </a-form-item>
      <a-form-item field="scoringStrategy" label="评分策略">
        <a-select
          v-model="form.scoringStrategy"
          :style="{ width: '320px' }"
          placeholder="请选择评分策略"
        >
          <a-option
            v-for="(value, key) of APP_SCORING_STRATEGY_MAP"
            :key="key"
            :label="value"
            :value="Number(key)"
          />
        </a-select>
      </a-form-item>
      <a-form-item>
        <a-button html-type="submit" style="width: 120px" type="primary">
          提交
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script lang="ts" setup>
import { defineProps, ref, watchEffect, withDefaults } from "vue";
import API from "@/api";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import {
  addAppUsingPost,
  editAppUsingPost,
  getAppVoByIdUsingGet,
} from "@/api/appController";
import { APP_SCORING_STRATEGY_MAP, APP_TYPE_MAP } from "@/constant/app";
import pictureUploader from "@/components/PictureUploader.vue";

interface Props {
  id: string;
}

const props = withDefaults(defineProps<Props>(), {
  id: () => {
    return "";
  },
});

const router = useRouter();

const form = ref({
  appDesc: "",
  appIcon: "",
  appName: "",
  appType: 0,
  scoringStrategy: 0,
} as API.AppAddRequest);

const oldApp = ref<API.AppVO>();

/**
 * 加载数据
 */
const loadData = async () => {
  if (!props.id) {
    return;
  }
  const res = await getAppVoByIdUsingGet({
    id: props.id as any,
  });
  if (res.data.code === 0 && res.data.data) {
    oldApp.value = res.data.data;
    form.value = res.data.data;
  } else {
    message.error("获取数据失败，" + res.data.message);
  }
};

// 获取旧数据
watchEffect(() => {
  loadData();
});

/**
 * 提交
 */
const handleSubmit = async () => {
  let res: any;
  // 如果是修改
  if (props.id) {
    res = await editAppUsingPost({
      id: props.id as any,
      ...form.value,
    });
  } else {
    // 创建
    res = await addAppUsingPost(form.value);
  }
  if (res.data.code === 0) {
    message.success("操作成功，即将跳转到应用详情页");
    setTimeout(() => {
      router.push(`/app/detail/${props.id || res.data.data}`);
    }, 3000);
  } else {
    message.error("操作失败，" + res.data.message);
  }
};
</script>

<style scoped>
#addAppPage {
  width: 500px;
  margin: auto;
  margin-top: 100px;
  padding: 30px;
  text-align: center;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#addAppPage h2 {
  margin-bottom: 30px;
}

a-form-item {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

a-form-item label {
  margin-right: 10px;
  color: #999;
}

a-input {
  width: 100%;
  max-width: 400px;
}

a-button {
  width: 120px;
  margin-right: 20px;
}

a-form-item:last-child {
  justify-content: flex-end;
}
</style>
