package com.example.a206684_biexianhe_izwan_lab1_1

// import - bring external classes, functions or packages into current file
// 把外部的类、函数或者包引入到当前文件中
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.listOf
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.example.a206684_biexianhe_izwan_lab1_1.ui.theme.A206684_BieXianhe_Izwan_Lab1_1Theme


class MainActivity : ComponentActivity() {
    //Define the main activity class 定义主活动类 - entry point of the app 入口
    //MainActivity inherits 继承 from ComponentActivity -
    //provide build-in Android Functionality已实现很多基础功能 如：lifecycle method 生命周期 onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        //override: override method from parent class 重写父类的方法
        //onCreate - a lifecycle method called when activity start
        //Activity生命周期里的启动函数，App打开时自动调用
        //Bundle - store previous stage 保存之前的数据 如：screen rotation 屏幕旋转 ? - can be null
        super.onCreate(savedInstanceState)
        //call the parent's onCreate method, ensure initialization 调用父类onCreate方法确保初始化
        //先执行系统（前任），再执行自己
        enableEdgeToEdge()
        //enable edge-to-edge display (content behind system bar)
        //让页面延伸到屏幕边缘
        setContent {
            //set the UI content using Jetpack Compose 设置整个APP的UI内容
            A206684_BieXianhe_Izwan_Lab1_1Theme() {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    bottomBar = { BottomBar() },
                    containerColor = MaterialTheme.colorScheme.background
                    //fix bottomBar at the bottom, automatically handle spacing
                    //自动把bottomBar固定在底部，自动处理内容和底部的间距
                ) { innerPadding ->
                    //Scaffold - layout structure 页面骨架 - provide top/bottom bar, content
                    //modifier.fillMaxSize() -> make the layout fill the whole screen 使组件占满屏幕
                    //innerPadding -> - padding provided by Scaffold 自动给的内边距，防止被挡overlap
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                        //call custom UI function and apply padding to it
                        //调用界面函数并传入padding
                    )
                }
            }
        }
    }
}

@Composable //mark this as UI function describe UI 表示这是一个界面函数
fun HomeScreen(modifier: Modifier = Modifier) {
    //modifier - control size大小, spacing/padding间距, layout布局
    //= Modifier - set default value 设默认值
    Column(modifier = modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    //verticalScroll - whole column enable vertical scrolling 启动垂直滚动
    //rememberScrollState - store and remember scroll position 记住并保持当前滚动位置
    //screen recomposes - will not jump back to top 界面刷新后不会回到顶部
    {
        //Column - vertical layout 垂直布局(top to bottom) fillMaxWidth - fill entire width 占满屏宽
        //TopBar()
        FunctionRow()
        SearchBar()
        LocationSuggestions()
        SpecialFeatures()
        DealsSection()
        RecommendedSection()
        LoginModule()
        //BottomBar() 应当删除：在上文中bottomBar = { BottomBar() }已经写了
        //custom composable function UI组件函数
        //Component-based design组件化 easy to maintain, reusable, clear structure
    }
}

@Composable
fun TopBar() {
    Row(
        //Row - horizontal layout 水平布局 (left - right)
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)//高度
            .background(MaterialTheme.colorScheme.primary)   // TopBar Background 背景色
            .padding(horizontal = 16.dp),//horizontal padding applies to entire row 整个rowの左右内边距
        verticalAlignment = Alignment.CenterVertically,//cross-axis alignment 交叉轴对齐
        //vertically centered 垂直居中
        horizontalArrangement = Arrangement.SpaceBetween//arrangement - main-axis distribution 主轴分布
    //space between items (push to edges) 左右分开，两端对齐，空隙均分
    ) {
        // Tripping.com
        Text(
            text = "Tripping.com",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 20.sp,//字号
            fontWeight = FontWeight.Bold//加粗
        )

        Card(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,

        ),

        ){

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "R",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}


@Composable
fun FunctionRow() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)

    ) {

        // Row1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            FunctionCardItem(
                R.drawable.hotel1,
                "Hotels",
                80.dp,
                28.dp
            )

            FunctionCardItem(
                R.drawable.flight1,
                "Flights",
                80.dp,
                28.dp
            )

            FunctionCardItem(
                R.drawable.dining1,
                "Dining",
                80.dp,
                28.dp
            )

            FunctionCardItem(
                R.drawable.train1,
                "Trains",
                80.dp,
                28.dp
            )

        }

        // Spacer
        Spacer(modifier = Modifier.height(12.dp))

        // Row2
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            FunctionCardItem(
                R.drawable.outline_apartment_24,
                "Apt",
                68.dp,
                24.dp
            )

            FunctionCardItem(
                R.drawable.attraction1,
                "Attractions",
                68.dp,
                24.dp
            )

            FunctionCardItem(
                R.drawable.outline_car_rental_24,
                "Car Rents",
                68.dp,
                24.dp
            )

            FunctionCardItem(
                R.drawable.grouptour1,
                "Groups",
                68.dp,
                24.dp
            )

            FunctionCardItem(
                R.drawable.outline_expand_circle_down_24,
                "More",
                68.dp,
                24.dp
            )
        }
    }
}

@Composable
fun FunctionCardItem(
    imageRes: Int,
    label: String,
    cardSize: Dp,
    iconSize: Dp
) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(cardSize),
        shape = RoundedCornerShape(12.dp),
        colors  = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = label,
                modifier = Modifier.size(iconSize)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 10.sp,
                softWrap = false,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun CircleShape(x0: Dp) {
    TODO("Not yet implemented")
}

@Composable
fun SearchBar() {

    var searchText by remember { mutableStateOf("") }
    //remember variable value, avoid variable reset each recomposition
    //mutableStateOf("") - create a mutable state 创建可变状态, initial value = ""
    //state change - UI recompose automatically
    val defaultText = "Search Places..."

    // Background
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)

            .padding(horizontal = 16.dp)
    //outer box, space between search bar and screen edges 外层，搜索框距离屏幕左右边缘
    ) {
        // White SearchBar
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 4.dp),//vertical+horizontal padding 水平/垂直页边距
                //.background(Color.White)
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            //SpaceAround - equal spaces between items include at edges 包括底，不会贴边
            //SpaceBetween - equal spaces between items not include at edges 不包括底，会贴边
        ) {
            // AI
            Image(
                painter = painterResource(id = R.drawable.ai1),
                contentDescription = "AI",
                modifier = Modifier.size(28.dp)
            )

            // Editable TextField
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(defaultText, color = MaterialTheme.colorScheme.surface) }, // default text
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )

            //SEARCH
            Image(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Search",
                modifier = Modifier
                    .size(28.dp)
                    .clickable(){

                    }
            )
        }
    }
}

@Composable
fun LocationSuggestions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 6.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        LazyRow(
            //support horizontal scrolling 支持横向滑动
            //handle overlap 处理溢出
            modifier = Modifier.weight(1f),
            //weight(1f) - take remaining space 占据剩余空间，避免把map挤出
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listOf("Barcelona", "Los Angeles", "Berlin", "Kuala Lumpur", "Moscow")) { city ->
                //items - create UI for each element in the list 为列表中生成的每个数据生成UI
                CityChip(city)
                //pass each city into CityChip 把每个城市传入函数
            }
        }


        /*{
        item {
               Box(
                   modifier = Modifier
                       .background(Color(0xFFE0F2F1))
                       .padding(horizontal = 10.dp, vertical = 4.dp)
               ) {
                   Text(
                       text = "Barcelona",
                       fontSize = 12.sp,
                       color = Color.Black
                   )
               }
           } (item {"Los Angeles", "Berlin", "Kuala Lumpur", "Moscow"})
           }*/

        // MAP
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_map_24),
                contentDescription = "Map",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Maps",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 4.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@Composable
fun CityChip(city: String) {
    //input parameter 输入参数（城市名）
    Card(
        modifier = Modifier

            .padding(horizontal = 10.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors  = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = city,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Composable
fun FeatureCard(
    imageRes: Int,
    label: String
) {

    Card(
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = label,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = label,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
fun SpecialFeatures() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        FeatureCard(R.drawable.deals1, "Deals")
        FeatureCard(R.drawable.events1, "Events")
        FeatureCard(R.drawable.planner1, "Planner")
        FeatureCard(R.drawable.pulse1, "Pulse")
        FeatureCard(R.drawable.ranking1, "Ranking")
        FeatureCard(R.drawable.guide1, "Guides")
        FeatureCard(R.drawable.moment1, "Moments")
    }
}

@Composable
fun DealsSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            //.background(Color.White)
            .padding(12.dp)
    ) {
        Column {

            // Line 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.discount1),
                        contentDescription = "discount",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = "Discount available",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        //.background(Color(0xFFE0F2F1))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("Claim all", fontSize = 11.sp)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tickets
            Row(
                modifier = Modifier.fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // Ticket1
                Card(
                    modifier = Modifier
                        //.weight(1f)
                        //.background(Color(0xFFF5F5F5))
                        .padding(8.dp)
                        .width(150.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors  = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.ticket1),
                            contentDescription = "ticket1",
                            modifier = Modifier.size(36.dp)
                        )

                        Column(
                            modifier = Modifier.padding(start = 6.dp)
                        ) {
                            Text("Hotels", fontSize = 12.sp)
                            Text("10% off", fontSize = 12.sp)
                        }
                    }
                }



                //Ticket2
                Card(
                    modifier = Modifier
                        //.weight(1f)
                        //.background(Color(0xFFF5F5F5))
                        .padding(8.dp)
                        .width(150.dp),
                            shape = RoundedCornerShape(12.dp),
                    colors  = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.ticket1),
                            contentDescription = "ticket2",
                            modifier = Modifier.size(36.dp)
                        )

                        Column(
                            modifier = Modifier.padding(start = 6.dp)
                        ) {
                            Text("Tickets", fontSize = 12.sp)
                            Text("5% off", fontSize = 12.sp)
                        }
                    }
                }

                //Ticket3
                Card(
                    modifier = Modifier
                        //.weight(1f)
                        //.background(Color(0xFFF5F5F5))
                        .padding(8.dp)
                        .width(150.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors  = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.ticket1),
                            contentDescription = "ticket3",
                            modifier = Modifier.size(36.dp)
                        )

                        Column(
                            modifier = Modifier.padding(start = 6.dp)
                        ) {
                            Text("Tickets", fontSize = 12.sp)
                            Text("15% off", fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendedSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.background(Color.White)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )

    //Row1
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
              //  .background(Color.White)
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Card1
            Card(
                modifier = Modifier
                    //.width(180.dp)
                    .weight(1f)//card takes equal portion of row 卡片均分row的宽度
                    .padding(end = 8.dp)//right spacing between cards 卡片右边距
                //    .background(Color(0xFFF5F5F5))
                    .padding(8.dp),//spacing inside card 卡片内部内容边距

                colors  = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),

                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column {

                    // Image
                    Image(
                        painter = painterResource(id = R.drawable.barcelona1),
                        contentDescription = "Barcelona",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    // Title
                    Text(
                        text = "Explore Barcelona",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 6.dp)
                    )

                    // Author + Views
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "by Alex",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )

                        Text(
                            text = "1.2k views",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            // Card2
            Card(
                modifier = Modifier
                    //.width(180.dp)
                    .weight(1f)
                    .padding(start = 8.dp)
                  //  .background(Color(0xFFF5F5F5))
                    .padding(8.dp),

                colors  = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),

                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.tokyo1),
                        contentDescription = "Tokyo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    Text(
                        text = "Trip in Tokyo",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 6.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "by Emma",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )

                        Text(
                            text = "980 views",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
    //Row2

        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.background(Color.White)
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Card3
            Card(
                modifier = Modifier
                    //.width(180.dp)
                    .weight(1f)//card takes equal portion of row 卡片均分row的宽度
                    .padding(end = 8.dp)//right spacing between cards 卡片右边距
                  //  .background(Color(0xFFF5F5F5))
                    .padding(8.dp),//spacing inside card 卡片内部内容边距

                colors  = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),

                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column {

                    // Image
                    Image(
                        painter = painterResource(id = R.drawable.paris1),
                        contentDescription = "Paris",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    // Title
                    Text(
                        text = "Visit Paris",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 6.dp)
                    )

                    // Author + Views
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "by Jason",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )

                        Text(
                            text = "1.9k views",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            // Card4
            Card(
                modifier = Modifier
                    //.width(180.dp)
                    .weight(1f)
                    .padding(start = 8.dp)
                    //.background(Color(0xFFF5F5F5))
                    .padding(8.dp),

                colors  = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),

                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.london1),
                        contentDescription = "London",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    Text(
                        text = "Discover London",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 6.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "by Allen",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )

                        Text(
                            text = "2.7k views",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }


@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        // Home
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.outline_home_24),
                contentDescription = "Home",
                modifier = Modifier.size(24.dp)
            )
            Text("Home", fontSize = 10.sp)
        }

        // Message
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.baseline_message_24),
                contentDescription = "Message",
                modifier = Modifier.size(24.dp)
            )
            Text("Messages", fontSize = 10.sp)
        }

        // Post
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.outline_add_24),
                contentDescription = "Post",
                modifier = Modifier.size(24.dp)
            )
            Text("Post", fontSize = 10.sp)
        }

        // My Trips
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.trip1),
                contentDescription = "My Trips",
                modifier = Modifier.size(24.dp)
            )
            Text("My Trips", fontSize = 10.sp)
        }

        // User
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.outline_account_circle_24),
                contentDescription = "User",
                modifier = Modifier.size(24.dp)
            )
            Text("User", fontSize = 10.sp)
        }
    }
}

@Composable
fun LoginModule() {

    //User Input
    var studentId by remember { mutableStateOf("") }
    // create a changeable state variable
    var name by remember { mutableStateOf("") }
    // remember - keep the value across recompositions 记住变量值，在重组recomposition时不丢失
    var loggedIn by remember { mutableStateOf(false) }
    //control login state true/false
    var expanded by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize(),  //animate
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            //title
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.clickable {
                    expanded = !expanded   //switch
                }
            )

            //expand
            if (expanded) {

                // Student_id + Login
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    TextField(
                        value = studentId,//current text shown in the TextField / displayer 显示器
                        onValueChange = { studentId = it },//update state
                        placeholder = { Text("student_id") },//placeholder - shown when input empty
                        singleLine = true,//single - line
                        modifier = Modifier.weight(1f)
                    )

                    Button(
                        onClick = { loggedIn = true },
                        modifier = Modifier.height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Login")
                    }
                }

                //name + reset
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text("name") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )

                    Button(
                        onClick = {
                            loggedIn = false
                            studentId = ""
                            name = ""
                        },
                        modifier = Modifier.height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Reset")
                    }
                }

                // Login result
                Text(
                    text = if (loggedIn)
                        "Welcome, $name, ID: $studentId"
                    else
                        "Please login",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickMove() {
    A206684_BieXianhe_Izwan_Lab1_1Theme() {
        HomeScreen()
    }
}