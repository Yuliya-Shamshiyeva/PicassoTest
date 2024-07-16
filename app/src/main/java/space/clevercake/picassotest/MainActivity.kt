package space.clevercake.picassotest

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // загрузить фотографию из интернета
        val logoUrl = "https://resources.jetbrains.com/storage/products/intellij-idea/img/meta/intellij-idea_logo_300x300.png"
        val imageView: ImageView = findViewById(R.id.image)
        Picasso.get()
            .load(logoUrl)//принимает путь к изображению. Это может быть файл на устройстве, идентификатор ресурса для рисования или ссылка на удаленный файл.
            .resize(300, 200)//изменяет его исходные пропорции
            .centerCrop()
            .rotate(90.0f)
            .transform(BlurTransformation(this))//для размытия
            .into(imageView, object : Callback {//после запятой обработчик ошибки если вдруг не загрузилось изображение
                override fun onSuccess() {
                    Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT)
                        .show()
                }
                override fun onError(e: Exception?) {
                    Toast.makeText(this@MainActivity, "Error!", Toast.LENGTH_SHORT)
                        .show()
                }
            })
    }
}