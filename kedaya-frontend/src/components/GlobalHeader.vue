<template>
  <a-row id="globalHeader" align="center" :wrap="false">
    <a-col flex="auto">
      <a-menu
        mode="horizontal"
        :default-selected-keys="selectedkeys"
        @menu-item-click="doMenuClick"
      >
        <a-menu-item
          key="0"
          :style="{ padding: 0, marginRight: '38px' }"
          disabled
        >
          <div class="titleBar">
            <img class="logo" src="../assets/logo.png" />
            <div class="title">可达鸭</div>
          </div>
        </a-menu-item>
        <a-menu-item v-for="item in visibleRoutes" :key="item.path">
          {{ item.name }}
        </a-menu-item>
      </a-menu>
    </a-col>
    <a-col flex="100px">
      <div>
        <a-button type="primary" href="/user/login">login</a-button>
      </div>
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
import { routes } from "@/router/routes";
import { ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
//当前选中的菜单项
const selectedkeys = ref(["/"]);
//路由更新时，自动更新选择的菜单项
router.afterEach((to, from, failure) => {
  selectedkeys.value = [to.path];
});

//展示在菜单栏的路由数组
const visibleRoutes = routes.filter((item) => {
  if (item.meta?.hideInMenu) {
    return false;
  }
  return true;
});

//点击菜单跳转到对应页面
const doMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};
</script>

<style scoped>
.titleBar {
  display: flex;
  align-items: center;
}

.title {
  color: black;
  margin-left: 16px;
}

.logo {
  height: 48px;
}
</style>
