import {Avatar} from "antd";
import {UserOutlined} from "@ant-design/icons";

export const StudentAvatar = ({name}) => {
    const splitName = name.split(' ')
    if (splitName.length < 2) return <Avatar icon={<UserOutlined/>}/>
    const [firstName, lastName] = splitName
    return <Avatar>{`${firstName[0]}${lastName[0]}`}</Avatar>
}