import { View, Image} from '@tarojs/components'
import { AtButton } from 'taro-ui'

import "taro-ui/dist/style/components/button.scss" // 按需引入
import './index.scss'

/**
 * 全局底部栏组件
 */

export default () => {
    return (
        <View className='GlobalFooter'>
            作者：Jason_Yang
        </View>
    )
}
