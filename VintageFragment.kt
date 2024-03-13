class VintageFragment : Fragment() {

    private var _binding: FragmentVintageBinding? = null
    private val binding get() = _binding!!

    private var number4: Int? = null
    private var number5: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVintageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        number4?.let { binding.textView4.text = it.toString() }
        number5?.let { binding.textView5.text = it.toString() }
    }

    fun setNumbers(number4: Int, number5: Int) {
        this.number4 = number4
        this.number5 = number5
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startVintageFragment(number4: Int, number5: Int) {
    val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
    val vintageFragment = VintageFragment()
    vintageFragment.setNumbers(number4, number5)
    fragmentManager.beginTransaction()
        .replace(android.R.id.content, vintageFragment)
        .addToBackStack(null)
        .commit()
    }
}